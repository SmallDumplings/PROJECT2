package com.example.project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.text.Layout;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.*;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.bumptech.glide.Glide;
import com.example.project.sticker.DrawableSticker;
import com.example.project.sticker.StickerView;
import com.example.project.sticker.TextSticker;
import com.yalantis.ucrop.UCrop;

import java.io.File;

public class TwoClass extends AppCompatActivity {
    ImageButton b1,b2,b4, b5;
    private FrameLayout container;
    private static final int REQUEST_IMAGE = 101;
    private String filename;
    private int xDelta, yDelta;

    static Bitmap bitmap;
    String text;

    Button f74ok;
    Button cancel;
    LinearLayout infoLayout;
    EditText text_input;
    RelativeLayout text_input_layout;
    ConstraintLayout constraintLayout;
    StickerView stickerView;
    HorizontalScrollView infoHorizentallayout;
    ImageView save;
    ImageView clearData;
    int i, b;
    ImageView view;
    ImageView imbg;




    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two_two_layout);
        container = findViewById(R.id.container);
        b5 = findViewById(R.id.b5);
        b2=findViewById(R.id.b2);
        b4=findViewById(R.id.b4);
        b1 = findViewById(R.id.b1);
        i = getIntent().getIntExtra("view", i);
        b = getIntent().getIntExtra("b", b);
        //imbg = findViewById(R.id.imbg);

        stickerView=findViewById(R.id.sticker_view);
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
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TwoClass.this, BackgroundClass.class);
                startActivity(intent);

                createBackground(b);


            }
        });

        text = getIntent().getStringExtra("text");
        TextSticker textSticker = new TextSticker(TwoClass.this);
        textSticker.setText(text);
        textSticker.setTextAlign(Layout.Alignment.ALIGN_CENTER);
        textSticker.resizeText();
        textSticker.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        stickerView.addSticker(textSticker);
        stickerView.invalidate();
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addTextInfo();

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


    public void addTextInfo() {

        this.text_input_layout = (RelativeLayout) findViewById(R.id.addtextlayout);
        this.text_input_layout.setVisibility(View.VISIBLE);
        this.text_input = (EditText) findViewById(R.id.textarea);
        this.f74ok = (Button) findViewById(R.id.add);
        this.cancel = (Button) findViewById(R.id.cancel);
        Log.d("My", text_input_layout + "     " + f74ok + "  " + cancel);
        this.f74ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (text_input.getText().toString().length() > 0) {
                    TextSticker textSticker = new TextSticker(TwoClass.this);
                    textSticker.setText(TwoClass.this.text_input.getText().toString());
                    textSticker.setTextAlign(Layout.Alignment.ALIGN_CENTER);
                    textSticker.resizeText();
                    textSticker.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                    stickerView.addSticker(textSticker);
                    stickerView.invalidate();
                    text_input.setText("");
                    text_input_layout.setVisibility(View.INVISIBLE);
                    return;
                }
                Toast.makeText(TwoClass.this, "No Input", Toast.LENGTH_SHORT).show();
            }
        });

        this.cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TwoClass.this.text_input.setText("");
                TwoClass.this.text_input_layout.setVisibility(View.INVISIBLE);
            }
        });

    }
    public void createLogo(int i){

        view=findViewById(i);
        TwoClass.this.stickerView.addSticker(new DrawableSticker(ContextCompat.getDrawable(TwoClass.this, i)));
        TwoClass.this.stickerView.invalidate();
        infoLayout.addView(view);
    }
    public void createBackground(int b){

        //imbg.setImageDrawable(ContextCompat.getDrawable(this, b));
    }
}




