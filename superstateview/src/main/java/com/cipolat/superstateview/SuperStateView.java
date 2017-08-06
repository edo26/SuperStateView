package com.cipolat.superstateview;

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
    public static final String IMAGE_POSITION_TOP = "TOP";
    public static final String IMAGE_POSITION_BOTTOM = "BOTTOM";
    public static final String IMAGE_POSITION_LEFT = "LEFT";
    public static final String IMAGE_POSITION_RIGTH = "RIGTH";

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
            Drawable image = array.getDrawable(R.styleable.superstateview_attr_imageResource);
            //posicion imagen
            String imgPos = array.getString(R.styleable.superstateview_attr_imagePosition);

            /******Defino Vistas*******/
            //Contenedor ppal
            LinearLayout masterLay = new LinearLayout(mContext);
            masterLay.setGravity(Gravity.CENTER);
            masterLay.setOrientation(VERTICAL);
            LayoutParams masterLayparams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            masterLay.setLayoutParams(masterLayparams);

            //Titulo

            LayoutParams lblParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

            TextView lblTitle = new TextView(mContext);
            lblTitle.setLayoutParams(lblParams);
            if (!textTitle.isEmpty())
                lblTitle.setText(textTitle);

            //seteo estilo en titulo si hay definidos
            if (titleStyle > 0)
                TextViewCompat.setTextAppearance(lblTitle, titleStyle);

            lblTitle.setGravity(Gravity.CENTER);

            //Custom Font
            if (titleFont != null) {
                Typeface typefaceTitl = null;
                try {
                    typefaceTitl = Typeface.createFromAsset(getContext().getAssets(), "fonts/" + subTitleFont);
                    lblTitle.setTypeface(typefaceTitl);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            //Imagen
            if (image != null) {
                int h = image.getIntrinsicHeight() ;
                int w = image.getIntrinsicWidth() ;
                image.setBounds(0, 0, w, h);
                //Posicion imagen
                if (imgPos != null) {
                    //se definio una posicion
                    switch (imgPos.toUpperCase()) {
                        case IMAGE_POSITION_TOP:
                            lblTitle.setCompoundDrawables(null, image, null, null);
                            break;
                        case IMAGE_POSITION_BOTTOM:
                            lblTitle.setCompoundDrawables(null, null, null, image);
                            break;
                        case IMAGE_POSITION_LEFT:
                            lblTitle.setCompoundDrawables(image, null, null, null);
                            break;
                        case IMAGE_POSITION_RIGTH:
                            lblTitle.setCompoundDrawables(null, null, image, null);
                            break;
                        default:
                            lblTitle.setCompoundDrawables(null, image, null, null);
                            break;
                    }
                } else
                    lblTitle.setCompoundDrawables(null, image, null, null);

                lblTitle.setCompoundDrawablePadding(10);
            }

            //SubTexto
            TextView subTitle = new TextView(mContext);
            subTitle.setLayoutParams(lblParams);

            if (!textSubTitle.isEmpty())
                subTitle.setText(textSubTitle);

            subTitle.setGravity(Gravity.CENTER);

            //Seteo estilo en titulo si hay definidos
            if (subTitleStyle > 0)
                TextViewCompat.setTextAppearance(subTitle, subTitleStyle);


            //Custom Font
            if (subTitleFont != null) {
                Typeface typefaceSub = null;
                try {
                    typefaceSub = Typeface.createFromAsset(getContext().getAssets(), "fonts/" + subTitleFont);
                    subTitle.setTypeface(typefaceSub);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            //Agrego views
            masterLay.addView(lblTitle);
            masterLay.addView(subTitle);
            addView(masterLay);
            array.recycle();
        }
    }
}

