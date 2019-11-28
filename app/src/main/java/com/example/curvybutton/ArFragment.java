package com.example.curvybutton;


import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.curvybutton.Model.MyItem;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ArFragment extends Fragment {

    public ArFragment() {
        // Required empty public constructor
    }

        @Override
        public View onCreateView (LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState){

            View view = inflater.inflate(R.layout.fragment_ar, container, false);


            ImageView imgOpen = (ImageView) view.findViewById(R.id.cargapn);
            ImageView imgOpen2 = (ImageView) view.findViewById(R.id.cargapp);
            ImageView imgOpen4 = (ImageView) view.findViewById(R.id.laminac);
            ImageView imgOpen5 = (ImageView) view.findViewById(R.id.dipolo);
            ImageView imgOpen6 = (ImageView) view.findViewById(R.id.lineacp);




            imgOpen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent in = new Intent(getActivity(), Ar1.class);
                    in.putExtra("some", "some data");
                    startActivity(in);
                }
            });

            imgOpen2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent in = new Intent(getActivity(), Ar2.class);
                    in.putExtra("some", "some data");
                    startActivity(in);
                }
            });

           imgOpen4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent in = new Intent(getActivity(), Ar4.class);
                    in.putExtra("some", "some data");
                    startActivity(in);
                }
            });

            imgOpen5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent in = new Intent(getActivity(), Ar5.class);
                    in.putExtra("some", "some data");
                    startActivity(in);
                }
            });

            imgOpen6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent in = new Intent(getActivity(), Ar6.class);
                    in.putExtra("some", "some data");
                    startActivity(in);
                }
            });


            return view;


        }

    }







/******************************************************
 Aplicacion Desarrollada por:
 Javier Mercado Velazquez
 Facultad de Estudios Superiores Aragon
 Ingenieria en Computacion
 11/27/19

 Aplicación digital realizada con el apoyo del Programa UNAM-DGAPA-PAPIME-PE110418"


 **********************************************************/


