package com.example.project;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.yalantis.ucrop.UCrop;

import java.io.File;

public class TwoClass extends AppCompatActivity {
    Button b1,b2,b3,b4, b5;
    private FrameLayout container;
    private static final int REQUEST_IMAGE = 101;
    private String filename;
    private int xDelta, yDelta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two_two_layout);
        container = findViewById(R.id.container);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_IMAGE);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TwoClass.this, DialogFragment.class);
                startActivity(intent);

            }
        });

    }
    @Override
    protected void onActivityResult ( int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_IMAGE: {
                    if (data != null && data.getData() != null) {
                        startCrop(data.getData());

                    }
                    break;
                }
                case UCrop.REQUEST_CROP: {
                    createImageView();
                    break;
                }
            }
        }
    }
    private void createImageView() {
        File file = new File(getCacheDir(), filename);
        Bitmap bmp = BitmapFactory.decodeFile(file.getAbsolutePath());
        ImageView imageView = new ImageView(TwoClass.this);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(250, 250);
        params.leftMargin = 0;
        params.topMargin = 0;
        imageView.setLayoutParams(params);
        imageView.setImageBitmap(bmp);
        imageView.setOnTouchListener(touchListener);
        container.addView(imageView);
        file.delete();
    }
    private void startCrop(Uri data) {
        String name = getFileName(data);
        File file = new File(getCacheDir(), name);
        filename = name;
        UCrop uCrop = UCrop.of(data, Uri.fromFile(file));
        uCrop.start(this);
    }
    private View.OnTouchListener touchListener = new View.OnTouchListener() {
        @Override public boolean onTouch(View view, MotionEvent event) {
            final int x = (int) event.getRawX();
            final int y = (int) event.getRawY();

            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_DOWN: {
                    FrameLayout.LayoutParams lParams = (FrameLayout.LayoutParams) view.getLayoutParams();

                    xDelta = x - lParams.leftMargin;
                    yDelta = y - lParams.topMargin;
                    break;
                }
                case MotionEvent.ACTION_UP: {
                    Toast.makeText(getApplicationContext(), "Объект перемещён", Toast.LENGTH_SHORT).show();
                    break;
                }
                case MotionEvent.ACTION_MOVE: {
                    if (x - xDelta + view.getWidth() <= container.getWidth()
                            && y - yDelta + view.getHeight() <= container.getHeight()
                            && x - xDelta >= 0
                            && y - yDelta >= 0) {
                        FrameLayout.LayoutParams layoutParams =
                                (FrameLayout.LayoutParams) view.getLayoutParams();
                        layoutParams.leftMargin = x - xDelta;
                        layoutParams.topMargin = y - yDelta;
                        layoutParams.rightMargin = 0;
                        layoutParams.bottomMargin = 0;
                        view.setLayoutParams(layoutParams);
                    }
                    break;
                }
            }
            container.invalidate();
            return true;
        }
    };

    public String getFileName(Uri uri) {
        String result = null;
        if (uri.getScheme().equals("content")) {
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                }
            } finally {
                cursor.close();
            }
        }
        if (result == null) {
            result = uri.getPath();
            int cut = result.lastIndexOf('/');
            if (cut != -1) {
                result = result.substring(cut + 1);
            }
        }
        return result;
    }
}



