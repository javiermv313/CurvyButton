package com.example.curvybutton;

/******************************************************
 Aplicacion Desarrollada por:
 Javier Mercado Velazquez
 Facultad de Estudios Superiores Aragon
 Ingenieria en Computacion
 11/27/19

 Aplicación digital realizada con el apoyo del Programa UNAM-DGAPA-PAPIME-PE110418"


 **********************************************************/

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
/*******************************Desarrollada Por Javier Mercado Velázquez_______________El chango Diaz *******************************************/
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sdsmdg.harjot.vectormaster.VectorMasterView;
import com.sdsmdg.harjot.vectormaster.models.PathModel;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    CurvedBottomNavigationView bottomNavigationView;
    VectorMasterView fab, fab1, fab2;
    RelativeLayout lin_id;
    PathModel outline;
    private Fragment arFragment;
    private Fragment userFragment;
    private Fragment modelsFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArFragment arFragment = new ArFragment();


        //View
        setFragment(arFragment);
        bottomNavigationView = (CurvedBottomNavigationView)findViewById(R.id.bottom_nav);
        fab = (VectorMasterView)findViewById(R.id.fab);
        fab1 = (VectorMasterView)findViewById(R.id.fab1);
        fab2 = (VectorMasterView)findViewById(R.id.fab2);



        lin_id = (RelativeLayout)findViewById(R.id.lin_id);
        bottomNavigationView.inflateMenu(R.menu.main_menu);

        //set event for bottom nav
        bottomNavigationView.setOnNavigationItemSelectedListener(this);



    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


        ArFragment arFragment = new ArFragment();
        ModelsFragment modelsFragment = new ModelsFragment();
        UserFragment userFragment = new UserFragment();

        switch (menuItem.getItemId())
        {
            case R.id.action_models:
                Toast.makeText(this, "Click on Rules", Toast.LENGTH_SHORT).show();
                setFragment(modelsFragment);
                //Animacion
                draw(6);
                //Ruta correcta usando el nombre
                lin_id.setX(bottomNavigationView.mFirstCurveControlPoint1.x);
                fab.setVisibility(View.VISIBLE);
                fab1.setVisibility(View.GONE);
                fab2.setVisibility(View.GONE);
                drawAnimation(fab);

                break;

            case R.id.action_ar:
                Toast.makeText(this, "Click on AR", Toast.LENGTH_SHORT).show();
                setFragment(arFragment);
                //Animacion
                draw(2);
                //Ruta correcta usando el nombre
                lin_id.setX(bottomNavigationView.mFirstCurveControlPoint1.x);
                fab.setVisibility(View.GONE);
                fab1.setVisibility(View.VISIBLE);
                fab2.setVisibility(View.GONE);
                drawAnimation(fab1);
                break;

            case R.id.action_usuario:
                Toast.makeText(this, "Click on Usuario", Toast.LENGTH_SHORT).show();
                setFragment(userFragment);
                //Animacion
                draw();
                //Ruta correcta usando el nombre
                lin_id.setX(bottomNavigationView.mFirstCurveControlPoint1.x);
                fab.setVisibility(View.GONE);
                fab1.setVisibility(View.GONE);
                fab2.setVisibility(View.VISIBLE);
                drawAnimation(fab2);
                break;
        }
        return true;
    }


    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }

    private void draw() {


        // Primero
        bottomNavigationView.mFirstCurveStartPoint.set((bottomNavigationView.mNavigationBarWidth *10/12)
                -(bottomNavigationView.CURVE_CIRCLE_RADIUS*2) - (bottomNavigationView.CURVE_CIRCLE_RADIUS/3), 0);

        bottomNavigationView.mFirstCurveEndPoint.set(bottomNavigationView.mNavigationBarWidth *10/12,
                bottomNavigationView.CURVE_CIRCLE_RADIUS
                +(bottomNavigationView.CURVE_CIRCLE_RADIUS/4));

        bottomNavigationView.mSecondCurveStartPoint = bottomNavigationView.mFirstCurveEndPoint;

        bottomNavigationView.mSecondCurveEndPoint.set((bottomNavigationView.mNavigationBarWidth *10/12)
                + (bottomNavigationView.CURVE_CIRCLE_RADIUS*2) + (bottomNavigationView.CURVE_CIRCLE_RADIUS/3),0);


        bottomNavigationView.mFirstCurveControlPoint1.set(bottomNavigationView.mFirstCurveStartPoint.x
                        + bottomNavigationView.CURVE_CIRCLE_RADIUS + (bottomNavigationView.CURVE_CIRCLE_RADIUS/4),
                bottomNavigationView.mFirstCurveStartPoint.y);

        bottomNavigationView.mFirstCurveControlPoint2.set(bottomNavigationView.mFirstCurveEndPoint.x
                        - (bottomNavigationView.CURVE_CIRCLE_RADIUS*2) + bottomNavigationView.CURVE_CIRCLE_RADIUS,
                bottomNavigationView.mFirstCurveEndPoint.y);

        //Segundo

        bottomNavigationView.mSecondCurveControlPoint1.set(bottomNavigationView.mSecondCurveStartPoint.x
                        + (bottomNavigationView.CURVE_CIRCLE_RADIUS*2) - bottomNavigationView.CURVE_CIRCLE_RADIUS,
                bottomNavigationView.mSecondCurveStartPoint.y);

        bottomNavigationView.mSecondCurveControlPoint2.set(bottomNavigationView.mSecondCurveEndPoint.x
                        - (bottomNavigationView.CURVE_CIRCLE_RADIUS + (bottomNavigationView.CURVE_CIRCLE_RADIUS/4)),
                bottomNavigationView.mSecondCurveEndPoint.y);

    }

    private void drawAnimation(final VectorMasterView fab) {
        outline = fab.getPathModelByName("outline");
        outline.setStrokeColor(Color.WHITE);
        outline.setTrimPathEnd(0.0f);
        //Init value animator
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimator.setDuration(1000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                outline.setTrimPathEnd((Float)valueAnimator.getAnimatedValue());
                fab.update();
            }
        });
        valueAnimator.start();

    }

    private void draw(int i) {
        // Primero
        bottomNavigationView.mFirstCurveStartPoint.set((bottomNavigationView.mNavigationBarWidth/i)
        -(bottomNavigationView.CURVE_CIRCLE_RADIUS*2) - (bottomNavigationView.CURVE_CIRCLE_RADIUS/3), 0);

        bottomNavigationView.mFirstCurveEndPoint.set(bottomNavigationView.mNavigationBarWidth/i,
                bottomNavigationView.CURVE_CIRCLE_RADIUS + (bottomNavigationView.CURVE_CIRCLE_RADIUS/4));

        bottomNavigationView.mSecondCurveStartPoint = bottomNavigationView.mFirstCurveEndPoint;

        bottomNavigationView.mSecondCurveEndPoint.set((bottomNavigationView.mNavigationBarWidth/i)
        + (bottomNavigationView.CURVE_CIRCLE_RADIUS*2) + (bottomNavigationView.CURVE_CIRCLE_RADIUS/3),0);


        bottomNavigationView.mFirstCurveControlPoint1.set(bottomNavigationView.mFirstCurveStartPoint.x
        + bottomNavigationView.CURVE_CIRCLE_RADIUS + (bottomNavigationView.CURVE_CIRCLE_RADIUS/4),
                bottomNavigationView.mFirstCurveStartPoint.y);

        bottomNavigationView.mFirstCurveControlPoint2.set(bottomNavigationView.mFirstCurveEndPoint.x
                        - (bottomNavigationView.CURVE_CIRCLE_RADIUS*2) + bottomNavigationView.CURVE_CIRCLE_RADIUS,
                bottomNavigationView.mFirstCurveEndPoint.y);

        //Segundo

        bottomNavigationView.mSecondCurveControlPoint1.set(bottomNavigationView.mSecondCurveStartPoint.x
                        + (bottomNavigationView.CURVE_CIRCLE_RADIUS*2) - bottomNavigationView.CURVE_CIRCLE_RADIUS,
                bottomNavigationView.mSecondCurveStartPoint.y);

        bottomNavigationView.mSecondCurveControlPoint2.set(bottomNavigationView.mSecondCurveEndPoint.x
                - (bottomNavigationView.CURVE_CIRCLE_RADIUS + (bottomNavigationView.CURVE_CIRCLE_RADIUS/4)),
                bottomNavigationView.mSecondCurveEndPoint.y);

    }

}
