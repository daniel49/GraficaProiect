package mygame;


//http://hub.jmonkeyengine.org/wiki/doku.php/jme3:advanced:physics


import com.jme3.app.SimpleApplication;
import com.jme3.bounding.BoundingBox;
import com.jme3.collision.CollisionResult;
import com.jme3.collision.CollisionResults;
import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.light.DirectionalLight;
import com.jme3.light.SpotLight;
import com.jme3.light.PointLight;
import com.jme3.light.AmbientLight;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.scene.Mesh;
import com.jme3.scene.Node;
import com.jme3.scene.debug.WireBox;
import com.jme3.scene.shape.Cylinder;
import com.jme3.scene.shape.Sphere;
/**
 * test
 * @author normenhansen
 */
public class Main extends SimpleApplication {
    
    Geometry geom;
    Node robot,base,turret,arm1,arm2,arm3,hand,botfinger1,botfinger2,topfinger1,topfinger2;
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {

   
   flyCam.setMoveSpeed(4);
         cam.setLocation(new Vector3f(10f,10f,10f));
         cam.lookAtDirection(new Vector3f(-12f,-7f,-3f), new Vector3f(0f,1f,0f));
	
         
        Box b = new Box(0.2f,0.2f,0.2f); // create cube shape
        geom = new Geometry("Box", b);  // create cube geometry from the shape
        geom.setLocalTranslation(new Vector3f(0,0,7));
        Material mat = new Material(assetManager,
          "Common/MatDefs/Misc/Unshaded.j3md");  // create a simple material
        mat.setColor("Color", ColorRGBA.White);   // set color of material to blue
        geom.setMaterial(mat);                   // set the cube's material
        rootNode.attachChild(geom); 
          
        robot = (Node)assetManager.loadModel("Models/robot/robot.j3o");
        base = (Node) robot.getChild("Base");
        rootNode.attachChild(base);
        turret = (Node) robot.getChild("Turret");
        base.attachChild(turret);
         arm1 = (Node) robot.getChild("Arm1");
        turret.attachChild(arm1);
         arm2 = (Node) robot.getChild("Arm2");
         arm2.rotate(0,0,FastMath.HALF_PI);
         arm2.setLocalTranslation(-0.05f,0,3f);
         arm1.attachChild(arm2);
         arm3 = (Node) robot.getChild("Arm3");
         arm3.setLocalTranslation(0,0,2.5f);
         arm2.attachChild(arm3);
         hand = (Node) robot.getChild("Hand");
         hand.rotate(0,-FastMath.HALF_PI,0);
         hand.setLocalTranslation(0,-0.5f,2.75f);
         arm3.attachChild(hand);

         botfinger1 = (Node) robot.getChild("BotFinger1");
         botfinger1.setLocalTranslation(0,-2f,-0.5f);
         botfinger1.rotate(0,-FastMath.HALF_PI,0);
         botfinger1.scale(2.5f);
        hand.attachChild(botfinger1);
         topfinger1 = (Node) robot.getChild("TopFinger1");        
         topfinger1.setLocalTranslation(0,-2f,0.5f);
         topfinger1.rotate(0,FastMath.HALF_PI,0);
         topfinger1.scale(2.5f);
        hand.attachChild(topfinger1);

         botfinger2 = (Node) robot.getChild("BotFinger2");
         botfinger2.setLocalTranslation(4,0,-4);
         botfinger2.rotate(FastMath.HALF_PI,0,0);
         botfinger2.rotate(0,-FastMath.HALF_PI,0);
         botfinger2.scale(7);
       botfinger1.attachChild(botfinger2);
         topfinger2 = (Node) robot.getChild("TopFinger2");
         topfinger2.setLocalTranslation(4,0,-4);
         topfinger2.rotate(-FastMath.HALF_PI,0,0);
         topfinger2.rotate(0,-FastMath.HALF_PI,0);
         topfinger2.scale(7);
        topfinger1.attachChild(topfinger2);

      DirectionalLight sun1 = new DirectionalLight();
      sun1.setColor(ColorRGBA.White);
        sun1.setDirection(new Vector3f(-1f, -0f, -5f));
        rootNode.addLight(sun1);
   
        AmbientLight sun2 = new AmbientLight();
      sun2.setColor(ColorRGBA.White.mult(5f));
        rootNode.addLight(sun2);
        
        
         // Calculate detection results
  
         // Calculate detection results
      
     
        
  
        
        initKeys();
        
        
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
    
    
    private ActionListener actionListener = new ActionListener() {
    public void onAction(String name, boolean keyPressed, float tpf) {
     if (name.equals("RotesteMana") && !keyPressed) {
          hand.rotate(0,FastMath.PI/36,0);
      }
      if (name.equals("DesfaGheare") && !keyPressed) {
          botfinger2.rotate(0,-FastMath.PI/36,0);
          topfinger2.rotate(0,-FastMath.PI/36,0);

      }
       if (name.equals("InchideGheare") && !keyPressed) {
          botfinger2.rotate(0,FastMath.PI/36,0);
          topfinger2.rotate(0,FastMath.PI/36,0);
      }
       if (name.equals("MutaMana1Jos") && !keyPressed) {
          arm1.rotate(0,FastMath.PI/36,0);
      }
        if (name.equals("MutaMana2Jos") && !keyPressed) {
          arm2.rotate(FastMath.PI/36,0,0);
      }
         if (name.equals("MutaMana3Jos") && !keyPressed) {
          arm3.rotate(0,FastMath.PI/36,0);
      }
          if (name.equals("MutaMana1Sus") && !keyPressed) {
          arm1.rotate(0,-FastMath.PI/36,0);
      }
        if (name.equals("MutaMana2Sus") && !keyPressed) {
          arm2.rotate(-FastMath.PI/36,0,0);
      }
         if (name.equals("MutaMana3Sus") && !keyPressed) {
          arm3.rotate(0,-FastMath.PI/36,0);
      }
         
          if (name.equals("RotesteIncheieturaManaStanga") && !keyPressed) {
          turret.rotate(0,FastMath.PI/72,0);
      }
           if (name.equals("RotesteIncheieturaManaDreapta") && !keyPressed) {
          turret.rotate(0,-FastMath.PI/72,0);
          
      }
           
            BoundingBox bbox = (BoundingBox) geom.getModelBound(); 
            
  CollisionResults results = new CollisionResults();
  topfinger2.collideWith(bbox, results);
  // Use the results
  if (results.size() > 0) {
    // how to react when a collision was detected
      CollisionResult closest  = results.getClosestCollision();
    rootNode.rotate(FastMath.PI,0,0);
  } else {
    // how to react when no collision occured
  }
    }
  };
    
    
    /** Custom Keybinding: Map named actions to inputs. */
  private void initKeys() {
    // You can map one or several inputs to one named action
      inputManager.addMapping("RotesteMana",  new KeyTrigger(KeyInput.KEY_1));
    inputManager.addMapping("DesfaGheare",  new KeyTrigger(KeyInput.KEY_2));
     inputManager.addMapping("InchideGheare",  new KeyTrigger(KeyInput.KEY_3));
     inputManager.addMapping("MutaMana1Jos",  new KeyTrigger(KeyInput.KEY_B));
      inputManager.addMapping("MutaMana2Jos",  new KeyTrigger(KeyInput.KEY_N));
       inputManager.addMapping("MutaMana3Jos",  new KeyTrigger(KeyInput.KEY_M));
       inputManager.addMapping("MutaMana1Sus",  new KeyTrigger(KeyInput.KEY_H));
      inputManager.addMapping("MutaMana2Sus",  new KeyTrigger(KeyInput.KEY_J));
       inputManager.addMapping("MutaMana3Sus",  new KeyTrigger(KeyInput.KEY_K));
        inputManager.addMapping("RotesteIncheieturaManaStanga",  new KeyTrigger(KeyInput.KEY_V));
       inputManager.addMapping("RotesteIncheieturaManaDreapta",  new KeyTrigger(KeyInput.KEY_G));


    // Add the names to the action listener.
       
       inputManager.addListener(actionListener,"RotesteMana");
inputManager.addListener(actionListener,"DesfaGheare");
inputManager.addListener(actionListener,"InchideGheare");
 inputManager.addListener(actionListener,"RotesteIncheieturaManaStanga");
inputManager.addListener(actionListener,"RotesteIncheieturaManaDreapta");
inputManager.addListener(actionListener,"MutaMana1Jos");
inputManager.addListener(actionListener,"MutaMana2Jos");
inputManager.addListener(actionListener,"MutaMana3Jos");

inputManager.addListener(actionListener,"MutaMana1Sus");
inputManager.addListener(actionListener,"MutaMana2Sus");
inputManager.addListener(actionListener,"MutaMana3Sus");
 
  }
}
