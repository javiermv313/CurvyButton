package com.example.curvybutton;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class Ar6 extends AppCompatActivity implements View.OnClickListener {
    ArFragment arFragment6;

    private ModelRenderable lineacpRenderable,
            cilindroRenderable,
            cilindrodaRenderable,
            cuboRenderable,
            cubodaRenderable,
            esferaRenderable,
            esferadaRenderable,
            irregularRenderable,
            irregulardaRenderable;



    ImageView lineacp, cilindro, cilindroda, cubo, cuboda,
            esfera, esferada, irregular, irregularda;

    View arrayView[];

    int selected = 1;

//    ViewRenderable name_obj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ar6);

        arFragment6 = (ArFragment)getSupportFragmentManager().findFragmentById(R.id.ux_fragment6);

        lineacp = (ImageView) findViewById(R.id.lineacp);
        cubo = (ImageView) findViewById(R.id.cubo);
        cilindro = (ImageView) findViewById(R.id.cilindro);
        cilindroda = (ImageView) findViewById(R.id.cilindroda);
        cuboda = (ImageView) findViewById(R.id.cuboda);
        esfera = (ImageView) findViewById(R.id.esfera);
        esferada = (ImageView) findViewById(R.id.esferada);
        irregular = (ImageView) findViewById(R.id.irregular);
        irregularda = (ImageView) findViewById(R.id.irregularda);

        setArrayView();
        setClickListener();
        setupModel();

        arFragment6.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener() {
            @Override
            public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {

                Anchor anchor = hitResult.createAnchor();

                AnchorNode anchorNode = new AnchorNode(anchor);

                anchorNode.setParent(arFragment6.getArSceneView().getScene());

                createModel(anchorNode, selected);

            }
        });

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            if(bundle.getString("some") != null){
                Toast.makeText(getApplicationContext(),
                        "data:" + bundle.getString("some"),
                        Toast.LENGTH_SHORT).show();
            }
        }

    }





    private void setupModel() {

        ModelRenderable.builder()
                .setSource(this, R.raw.lineacp)
                .build()
                .thenAccept(renderable -> lineacpRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast =
                                    Toast.makeText(this, "unable to load cargapn", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            return null;

                        }
                );


        ModelRenderable.builder()
                .setSource(this, R.raw.cubo)
                .build()
                .thenAccept(renderable -> cuboRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast =
                                    Toast.makeText(this, "unable to load cargapn", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            return null;

                        }
                );


        ModelRenderable.builder()
                .setSource(this, R.raw.cuboda)
                .build()
                .thenAccept(renderable -> cubodaRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast =
                                    Toast.makeText(this, "unable to load cargapn", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            return null;

                        }
                );

        ModelRenderable.builder()
                .setSource(this, R.raw.cilindro)
                .build()
                .thenAccept(renderable -> cilindroRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast =
                                    Toast.makeText(this, "unable to load cubo", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            return null;

                        }
                );

        ModelRenderable.builder()
                .setSource(this, R.raw.cilindroda)
                .build()
                .thenAccept(renderable -> cilindrodaRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast =
                                    Toast.makeText(this, "unable to load cargapn", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            return null;

                        }
                );

        ModelRenderable.builder()
                .setSource(this, R.raw.esfera)
                .build()
                .thenAccept(renderable -> esferaRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast =
                                    Toast.makeText(this, "unable to load cubo", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            return null;

                        }
                );

        ModelRenderable.builder()
                .setSource(this, R.raw.esferada)
                .build()
                .thenAccept(renderable -> esferadaRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast =
                                    Toast.makeText(this, "unable to load cargapn", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            return null;

                        }
                );

        ModelRenderable.builder()
                .setSource(this, R.raw.irregular)
                .build()
                .thenAccept(renderable -> irregularRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast =
                                    Toast.makeText(this, "unable to load cubo", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            return null;

                        }
                );

        ModelRenderable.builder()
                .setSource(this, R.raw.irregularda)
                .build()
                .thenAccept(renderable -> irregulardaRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast =
                                    Toast.makeText(this, "unable to load cargapn", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            return null;

                        }
                );


    }





    public void setArrayView() {

        arrayView = new View[]{
                lineacp, cubo, cuboda, cilindro, cilindroda, esfera, esferada, irregular,
                irregularda
        };

    }

    private void createModel(AnchorNode anchorNode, int selected) {
        if (selected == 1) {
            TransformableNode lineacp = new TransformableNode(arFragment6.getTransformationSystem());
            lineacp.setParent(anchorNode);
            lineacp.setRenderable(lineacpRenderable);
            lineacp.select();

            //addName(anchorNode,cargapn,"CargaPN");
        }

        if (selected == 2) {
            TransformableNode cubo = new TransformableNode(arFragment6.getTransformationSystem());
            cubo.setParent(anchorNode);
            cubo.setRenderable(cuboRenderable);
            cubo.select();

            //addName(anchorNode,cubo,"Cubo");
        }
        if (selected == 3) {
            TransformableNode cuboda = new TransformableNode(arFragment6.getTransformationSystem());
            cuboda.setParent(anchorNode);
            cuboda.setRenderable(cubodaRenderable);
            cuboda.select();

            //addName(anchorNode,cuboda,"Cuboda");
        }

        if (selected == 4) {
            TransformableNode cilindro = new TransformableNode(arFragment6.getTransformationSystem());
            cilindro.setParent(anchorNode);
            cilindro.setRenderable(cilindroRenderable);
            cilindro.select();

            //addName(anchorNode,cilindro,"Cilindro");
        }
        if (selected == 5) {
            TransformableNode cilindroda = new TransformableNode(arFragment6.getTransformationSystem());
            cilindroda.setParent(anchorNode);
            cilindroda.setRenderable(cilindrodaRenderable);
            cilindroda.select();

            //addName(anchorNode,cilindroda,"CilindroDA");
        }

        if (selected == 6) {
            TransformableNode esfera = new TransformableNode(arFragment6.getTransformationSystem());
            esfera.setParent(anchorNode);
            esfera.setRenderable(esferaRenderable);
            esfera.select();

            //addName(anchorNode,esfera,"Esfera");
        }
        if (selected == 7) {
            TransformableNode esferada = new TransformableNode(arFragment6.getTransformationSystem());
            esferada.setParent(anchorNode);
            esferada.setRenderable(esferadaRenderable);
            esferada.select();

            //addName(anchorNode,esferada,"EsferaDA");
        }


        if (selected == 8) {
            TransformableNode irregular = new TransformableNode(arFragment6.getTransformationSystem());
            irregular.setParent(anchorNode);
            irregular.setRenderable(irregularRenderable);
            irregular.select();

            //addName(anchorNode,irregular,"Irregular");
        }
        if (selected == 9) {
            TransformableNode irregularda = new TransformableNode(arFragment6.getTransformationSystem());
            irregularda.setParent(anchorNode);
            irregularda.setRenderable(irregulardaRenderable);
            irregularda.select();

            //addName(anchorNode,irregularda,"IrregularDA");
        }


    }


    private void addName(AnchorNode anchorNode, TransformableNode model, String name) {

        ViewRenderable.builder().setView(this, R.layout.name_obj)
                .build()
                .thenAccept(viewRenderable -> {

                    TransformableNode nameView = new TransformableNode(arFragment6.getTransformationSystem());
                    nameView.setLocalPosition(new Vector3(0f, model.getLocalPosition().y + 0.5f, 0));
                    nameView.setParent(anchorNode);
                    nameView.setRenderable(viewRenderable);
                    nameView.select();

                    //set Text

                    TextView txt_name = (TextView) viewRenderable.getView();
                    txt_name.setText(name);
                    txt_name.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            anchorNode.setParent(null);
                        }
                    });

                });

    }



        public void setClickListener() {
            for (int i=0; i<arrayView.length;i++)
                arrayView[i].setOnClickListener(this);
    }







        @Override
        public void onClick (View view){

        if (view.getId() == R.id.lineacp) {
            selected = 1;
            setBackground(view.getId());


        } else if (view.getId() == R.id.cubo) {
            selected = 2;
            setBackground(view.getId());


        }
        if (view.getId() == R.id.cuboda) {
                selected = 3;
                setBackground(view.getId());
        } else if (view.getId() == R.id.cilindro) {
                selected = 4;
                setBackground(view.getId());
            }
        if (view.getId() == R.id.cilindroda) {
                selected = 5;
                setBackground(view.getId());
        } else if (view.getId() == R.id.esfera) {
                selected = 6;
                setBackground(view.getId());
            }
        if (view.getId() == R.id.esferada) {
                selected = 7;
                setBackground(view.getId());
        } else if (view.getId() == R.id.irregular) {
                selected = 8;
                setBackground(view.getId());
        }
            if (view.getId() == R.id.irregularda) {
                selected = 9;
                setBackground(view.getId());
            }
    }
  //  }


    public void setBackground(int id) {
        for (int i = 0; i < arrayView.length; i++) {
            if (arrayView[i].getId() == id)
                arrayView[i].setBackgroundColor(Color.parseColor("#80333639"));
            else
                arrayView[i].setBackgroundColor(Color.TRANSPARENT);
        }
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

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


