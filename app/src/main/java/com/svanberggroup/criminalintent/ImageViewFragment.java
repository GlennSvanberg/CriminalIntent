package com.svanberggroup.criminalintent;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.io.File;

public class ImageViewFragment extends DialogFragment {

    private static final String DIALOG_IMAGE = "DialogImage";

    private ImageView mImageView;

    public static ImageViewFragment newInstance(String imageFile) {
        Bundle args = new Bundle();
        args.putSerializable(DIALOG_IMAGE, imageFile);

        ImageViewFragment fragment = new ImageViewFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        String imageFile = (String) getArguments().getSerializable(DIALOG_IMAGE);

        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_image, null);
        mImageView = (ImageView) v.findViewById(R.id.crimeImageView);

        Bitmap bitmap = PictureUtils.getScaledBitmap(imageFile, getActivity());
        mImageView.setImageBitmap(bitmap);

        return new AlertDialog.Builder(getActivity()).setView(v).create();
    }
}

