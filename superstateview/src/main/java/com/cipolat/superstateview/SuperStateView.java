package com.cipolat.superstateview;
/*

/  ___|                     /  ___| |      | |      | | | (_)
\ `--. _   _ _ __   ___ _ __\ `--.| |_ __ _| |_ ___ | | | |_  _____      __
 `--. \ | | | '_ \ / _ \ '__|`--. \ __/ _` | __/ _ \| | | | |/ _ \ \ /\ / /
/\__/ / |_| | |_) |  __/ |  /\__/ / || (_| | ||  __/\ \_/ / |  __/\ V  V /
\____/ \__,_| .__/ \___|_|  \____/ \__\__,_|\__\___| \___/|_|\___| \_/\_/
            | |
            |_|

  Created by Sebastian Cipolat
  Version:1.0.2
  ARGENTINA 2017
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.TextViewCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by sebastian on 02/06/16.
 */
public class SuperStateView extends LinearLayout {
    private Context mContext;
    private TextView lblTitle;
    private TextView subTitle;

    public SuperStateView(Context context) {
        super(context);
        this.mContext = context;
    }

    public SuperStateView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        setUI(attrs);
    }

    public SuperStateView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = context;
        setUI(attrs);
    }

    public void setUI(AttributeSet attrs) {
        if (attrs != null) {
            /***Atributos**/
            TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.superstateview_attr);

            //Titulo
            String textTitle = array.getString(R.styleable.superstateview_attr_setTitleText);
            //Subtitulo
            String textSubTitle = array.getString(R.styleable.superstateview_attr_setSubTitleText);
            //Estilo Titulo/subtitulo
            int titleStyle = array.getResourceId(R.styleable.superstateview_attr_titleStyle, 0);
            int subTitleStyle = array.getResourceId(R.styleable.superstateview_attr_subTitleStyle, 0);
            //CustomFonts
            String titleFont = array.getString(R.styleable.superstateview_attr_setTitleFont);
            String subTitleFont = array.getString(R.styleable.superstateview_attr_setSubTitleFont);
            //Imagen
            Drawable image = array.getDrawable(R.styleable.superstateview_attr_imageState);
            //posicion imagen
            /******Defino Vistas*******/
            //Contenedor ppal
            LinearLayout masterLay = new LinearLayout(mContext);
            masterLay.setGravity(Gravity.CENTER);
            masterLay.setOrientation(VERTICAL);
            LayoutParams masterLayparams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            masterLay.setLayoutParams(masterLayparams);
            //Titulo
            LayoutParams lblParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            this.lblTitle = new TextView(mContext);
            this.lblTitle.setLayoutParams(lblParams);
            if (textTitle != null && !textTitle.isEmpty())
                this.lblTitle.setText(textTitle);

            //seteo estilo en titulo si hay definidos
            setTexViewStyle(this.lblTitle, titleStyle);

            this.lblTitle.setGravity(Gravity.CENTER);

            //Custom Font
            setTexViewExternalFont(this.lblTitle, titleFont);
            //Imagen
            setImageTop(lblTitle, image);
            //SubTexto
            subTitle = new TextView(mContext);
            subTitle.setLayoutParams(lblParams);
            if (textSubTitle != null && !textSubTitle.isEmpty())
                subTitle.setText(textSubTitle);

            subTitle.setGravity(Gravity.CENTER);

            //Seteo estilo en titulo si hay definidos
            setTexViewStyle(this.subTitle, subTitleStyle);

            setTexViewExternalFont(this.subTitle, subTitleFont);

            //Agrego views
            masterLay.addView(lblTitle);
            masterLay.addView(subTitle);
            addView(masterLay);
            array.recycle();
        }
    }

    public void setTitleText(String text) {
        this.lblTitle.setText(text);
    }

    public void setSubTitleText(String text) {
        this.subTitle.setText(text);
    }

    public void setImageState(Drawable image) {
        setImageTop(this.lblTitle, image);
    }

    public void setTitleFont(String fontName) {
        setTexViewExternalFont(this.lblTitle, fontName);
    }

    public void setSubTitleFont(String fontName) {
        setTexViewExternalFont(this.subTitle, fontName);
    }

    public void setTitleStyle(int styleID) {
        setTexViewStyle(this.lblTitle, styleID);
    }

    public void setSubTitleStyle(int styleID) {
        setTexViewStyle(this.subTitle, styleID);
    }

    private void setTexViewExternalFont(TextView lbl, String fontName) {
        if (fontName != null && !fontName.isEmpty()) {
            Typeface typefaceTitl = null;
            try {
                typefaceTitl = Typeface.createFromAsset(getContext().getAssets(), "fonts/" + fontName);
                lbl.setTypeface(typefaceTitl);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void setTexViewStyle(TextView lbl, int styleID) {
        if (styleID > 0)
            TextViewCompat.setTextAppearance(lbl, styleID);
    }

    private void setImageTop(TextView lbl, Drawable image) {
        if (image != null) {
            int h = image.getIntrinsicHeight();
            int w = image.getIntrinsicWidth();
            image.setBounds(0, 0, w, h);
            lbl.setCompoundDrawables(null, image, null, null);
            lbl.setCompoundDrawablePadding(10);
        }
    }
}

