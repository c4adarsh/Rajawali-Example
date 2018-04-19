package com.adarsh.rajawali3d;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;

import org.rajawali3d.Object3D;
import org.rajawali3d.lights.DirectionalLight;
import org.rajawali3d.loader.LoaderOBJ;
import org.rajawali3d.loader.ParsingException;
import org.rajawali3d.materials.Material;
import org.rajawali3d.materials.methods.DiffuseMethod;
import org.rajawali3d.materials.textures.ATexture;
import org.rajawali3d.materials.textures.Texture;
import org.rajawali3d.math.vector.Vector3;
import org.rajawali3d.primitives.Sphere;
import org.rajawali3d.renderer.Renderer;

/**
 * Created by adarsh on 4/18/2018.
 */

public class ObjRenderer extends Renderer{


    private static final String TAG = BasicRenderer.class.getSimpleName() ;
    private Object3D Object;
    private DirectionalLight mDirectionalLight;
    private Context context;

    public ObjRenderer(Context context) {
        super(context);
        this.context = context;
        setFrameRate(60);
    }

    @Override
    protected void initScene() {
        LoaderOBJ objParser = new LoaderOBJ(this,R.raw.cube_obj);
        try {

            objParser.parse();
            Object = objParser.getParsedObject();
            getCurrentScene().addChild(Object);

        } catch (ParsingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onOffsetsChanged(float xOffset, float yOffset, float xOffsetStep, float
            yOffsetStep, int xPixelOffset, int yPixelOffset) {

    }

    @Override
    protected void onRender(long ellapsedRealtime, double deltaTime) {
        super.onRender(ellapsedRealtime, deltaTime);
        //mEarthSphere.rotate(Vector3.Axis.Y, 1.0);
    }

    @Override
    public void onTouchEvent(MotionEvent event) {

    }

}
