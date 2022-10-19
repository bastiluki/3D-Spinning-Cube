import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class Main extends Canvas implements Runnable {

    //triangles for cube
    //1: (-1, -1, -1) (1, 1, -1) (-1, 1, -1)
    //2: (-1, -1, -1) (1, -1, -1) (1, 1, -1)

    //3: (-1, -1, -1) (-1, 1, 1) (-1, -1, 1)
    //4: (-1, -1, -1) (-1, 1, -1) (-1, 1, 1)

    //5: (1, 1, 1) (1, -1, 1) (-1, -1, 1)
    //6: (1, 1, 1) (-1, -1, 1) (-1, 1, 1)

    //7: (1, -1, -1) (1, 1, 1) (1, 1, -1)
    //8: (1, -1, -1) (1, -1, 1) (1, 1, 1)

    //9: (-1, 1, -1) (1, 1, 1) (-1, 1, 1)
    //10: (-1, 1, -1) (1, 1, -1) (1, 1, 1)

    //11: (-1, -1, -1) (1, 1, -1) (1, -1, 1)
    //12: (-1, -1, -1) (1, -1, 1) (-1, -1, 1)

    double[] tri1_x = {-1, -1, -1};    double[] tri3_x = {-1, -1, -1};
    double[] tri1_y = {-1, 1, 1};      double[] tri3_y = {-1, 1, -1};
    double[] tri1_z = {-1, -1, -1};    double[] tri3_z = {-1, 1, 1};

    double[] tri2_x = {-1, 1, 1};      double[] tri4_x ={-1, -1, -1};
    double[] tri2_y = {-1, -1, 1};     double[] tri4_y ={-1, 1, 1};
    double[] tri2_z = {-1, -1, -1};    double[] tri4_z ={-1, -1, 1};

    double[] tri5_x = {1, 1, -1};      double[] tri7_x = {1, 1, 1};
    double[] tri5_y = {1, -1, -1};     double[] tri7_y = {-1, 1, 1};
    double[] tri5_z = {1, 1, 1};       double[] tri7_z = {-1, 1, -1};

    double[] tri6_x = {1, -1, -1};     double[] tri8_x ={1, 1, 1};
    double[] tri6_y = {1, -1, 1};      double[] tri8_y ={-1, -1, 1};
    double[] tri6_z = {1, 1, 1};       double[] tri8_z ={-1, 1, 1};

    double[] tri9_x = {-1, 1, -1};     double[] tri11_x = {-1, 1, 1};
    double[] tri9_y = {1, 1, 1};       double[] tri11_y = {-1, 1, -1};
    double[] tri9_z = {-1, 1, 1};      double[] tri11_z = {-1, -1, 1};

    double[] tri10_x = {-1, 1, 1};     double[] tri12_x ={-1, 1, -1};
    double[] tri10_y = {1, 1, 1};      double[] tri12_y ={-1, -1, -1};
    double[] tri10_z = {-1, -1, 1};    double[] tri12_z ={-1, 1, 1};

    triangle tris1 = new triangle();
    triangle tris2 = new triangle();
    triangle tris3 = new triangle();
    triangle tris4 = new triangle();
    triangle tris5 = new triangle();
    triangle tris6 = new triangle();
    triangle tris7 = new triangle();
    triangle tris8 = new triangle();
    triangle tris9 = new triangle();
    triangle tris10 = new triangle();
    triangle tris11 = new triangle();
    triangle tris12 = new triangle();

    Math math = new Math();

    int scale = 100;
    int mid_x = WIDTH / 2;
    int mid_y = HEIGHT / 2;

    double angle = 0.00;

    public static final int WIDTH = 800, HEIGHT = 600;

    public ArrayList<triangle> triangles = new ArrayList<>();
    public ArrayList<triangle> trianglesZ = new ArrayList<>();
    public ArrayList<triangle> trianglesY = new ArrayList<>();
    public ArrayList<triangle> trianglesX = new ArrayList<>();
    public ArrayList<triangle> trianglesProjected = new ArrayList<>();

    private Thread thread;
    private boolean running = false;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        new Window(WIDTH + 16, HEIGHT + 39, "3D", this);

        tris1.setX_3d(tri1_x);
        tris1.setY_3d(tri1_y);
        tris1.setZ_3d(tri1_z);

        tris2.setX_3d(tri2_x);
        tris2.setY_3d(tri2_y);
        tris2.setZ_3d(tri2_z);

        tris3.setX_3d(tri3_x);
        tris3.setY_3d(tri3_y);
        tris3.setZ_3d(tri3_z);

        tris4.setX_3d(tri4_x);
        tris4.setY_3d(tri4_y);
        tris4.setZ_3d(tri4_z);

        tris5.setX_3d(tri5_x);
        tris5.setY_3d(tri5_y);
        tris5.setZ_3d(tri5_z);

        tris6.setX_3d(tri6_x);
        tris6.setY_3d(tri6_y);
        tris6.setZ_3d(tri6_z);

        tris7.setX_3d(tri7_x);
        tris7.setY_3d(tri7_y);
        tris7.setZ_3d(tri7_z);

        tris8.setX_3d(tri8_x);
        tris8.setY_3d(tri8_y);
        tris8.setZ_3d(tri8_z);

        tris9.setX_3d(tri9_x);
        tris9.setY_3d(tri9_y);
        tris9.setZ_3d(tri9_z);

        tris10.setX_3d(tri10_x);
        tris10.setY_3d(tri10_y);
        tris10.setZ_3d(tri10_z);

        tris11.setX_3d(tri11_x);
        tris11.setY_3d(tri11_y);
        tris11.setZ_3d(tri11_z);

        tris12.setX_3d(tri12_x);
        tris12.setY_3d(tri12_y);
        tris12.setZ_3d(tri12_z);

        triangles.add(tris1); triangles.add(tris2); triangles.add(tris3);
        triangles.add(tris4); triangles.add(tris5); triangles.add(tris6);
        triangles.add(tris7); triangles.add(tris8); triangles.add(tris9);
        triangles.add(tris10); /*triangles.add(tris11);*/ triangles.add(tris12);
    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running)
                render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                //System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick(){

    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);


        for(int i = 0; i <= triangles.size() - 1; i++) {
            trianglesZ.add(math.rotationMatrixZ(angle, triangles.get(i)));
        }

        for(int i = 0; i <= trianglesZ.size() - 1; i++) {
            trianglesY.add(math.rotationMatrixY(angle, trianglesZ.get(i)));
        }

        for(int i = 0; i <= trianglesY.size() - 1; i++) {
            trianglesX.add(math.rotationMatrixX(angle, trianglesY.get(i)));
        }

        for(int i = 0; i <= trianglesX.size() - 1; i++) {
            trianglesProjected.add(math.projectionMatrix(trianglesX.get(i)));
        }

        for(int i = 0; i <= trianglesProjected.size() - 1; i++) {
            //renderTriangle(g, trianglesProjected.get(i));
            renderFullTriangle(g, trianglesProjected.get(i));
        }

        //angle = 0.11000;
        angle += 0.00005;

        g.dispose();
        bs.show();

        trianglesZ.removeAll(trianglesZ);
        trianglesY.removeAll(trianglesY);
        trianglesX.removeAll(trianglesX);

        trianglesProjected.removeAll(trianglesProjected);
    }

    public void renderTriangle(Graphics g, triangle tris){
        g.setColor(Color.WHITE);

        g.drawLine((int) (tris.getX_2d(0) * scale + mid_x),
                (int) (tris.getY_2d(0)  * scale + mid_y),
                (int) (tris.getX_2d(1) * scale + mid_x),
                (int) (tris.getY_2d(1) * scale + mid_y));
        g.drawLine((int) (tris.getX_2d(1) * scale + mid_x),
                (int) (tris.getY_2d(1) * scale + mid_y),
                (int) (tris.getX_2d(2) * scale + mid_x),
                (int) (tris.getY_2d(2) * scale + mid_y));
        g.drawLine((int) (tris.getX_2d(2) * scale + mid_x),
                (int) (tris.getY_2d(2) * scale + mid_y),
                (int) (tris.getX_2d(0) * scale + mid_x),
                (int) (tris.getY_2d(0) * scale + mid_y));
    }

    public void renderFullTriangle(Graphics g, triangle tris){
        double x1 = 0;
        double y1 = 0;
        double x2 = 0;
        double y2 = 0;
        double x3 = 0;
        double y3 = 0;

        double x1_rendered = tris.getX_2d(0) * scale + mid_x;
        double y1_rendered = tris.getY_2d(0) * scale + mid_y;
        double x2_rendered = tris.getX_2d(1) * scale + mid_x;
        double y2_rendered = tris.getY_2d(1) * scale + mid_y;
        double x3_rendered = tris.getX_2d(2) * scale + mid_x;
        double y3_rendered = tris.getY_2d(2) * scale + mid_y;

        double middle_x = (x1_rendered + x2_rendered + x3_rendered) / 3;
        double middle_y = (y1_rendered + y2_rendered + y3_rendered) / 3;

        int lenght = 0;

        if(x1_rendered < middle_x && y1_rendered < middle_y){
            int x_3rd = (int) x1_rendered;
            int y_3rd = (int) middle_y;

            int lenghtSide2 = (int) middle_x - x_3rd;
            int lenghtSide1 = y_3rd - (int) y1_rendered;

            lenght = (int) java.lang.Math.sqrt((lenghtSide1 * lenghtSide1) + (lenghtSide2 * lenghtSide2));
        }
        if(x1_rendered < middle_x && y1_rendered > middle_y){
            int x_3rd = (int) x1_rendered;
            int y_3rd = (int) middle_y;

            int lenghtSide2 = (int) middle_x - x_3rd;
            int lenghtSide1 = (int) y1_rendered - y_3rd;

            lenght = (int) java.lang.Math.sqrt((lenghtSide1 * lenghtSide1) + (lenghtSide2 * lenghtSide2));
        }
        if(x1_rendered > middle_x && y1_rendered < middle_y){
            int x_3rd = (int) x1_rendered;
            int y_3rd = (int) middle_y;

            int lenghtSide2 = x_3rd - (int) middle_x;
            int lenghtSide1 = y_3rd - (int) y1_rendered;

            lenght = (int) java.lang.Math.sqrt((lenghtSide1 * lenghtSide1) + (lenghtSide2 * lenghtSide2));
        }
        if(x1_rendered > middle_x && y1_rendered > middle_y){
            int x_3rd = (int) x1_rendered;
            int y_3rd = (int) middle_y;

            int lenghtSide2 = x_3rd - (int) middle_x;
            int lenghtSide1 = (int) y1_rendered - y_3rd;

            lenght = (int) java.lang.Math.sqrt((lenghtSide1 * lenghtSide1) + (lenghtSide2 * lenghtSide2));
        }

        double b1, b2, b3;
        double m1, m2, m3;
        double a, b, c, d, e, f;

        a = middle_y - ((y1_rendered / x1_rendered) * middle_x);
        b = ((middle_x / x1_rendered) * -1) + 1;
        b1 = a / b;
        m1 = (y1_rendered / x1_rendered)- (b1 / x1_rendered);

        c = middle_y - ((y2_rendered / x2_rendered) * middle_x);
        d = ((middle_x / x2_rendered) * -1) + 1;
        b2 = c / d;
        m2 = (y2_rendered / x2_rendered)- (b2 / x2_rendered);

        e = middle_y - ((y3_rendered / x3_rendered) * middle_x);
        f = ((middle_x / x3_rendered) * -1) + 1;
        b3 = e / f;
        m3 = (y3_rendered / x3_rendered)- (b3 / x3_rendered);

        x1 = x1_rendered;
        x2 = x2_rendered;
        x3 = x3_rendered;

        for(int i = 0; i < lenght; i++){
            if(x1_rendered < middle_x){
                y1 = x1 * m1 + b1;

                x1++;
            } else {
                y1 = x1 * m1 + b1;

                x1--;
            }

            if(x2_rendered < middle_x){
                y2 = x2 * m2 + b2;

                x2++;
            } else {
                y2 = x2 * m2 + b2;

                x2--;
            }

            if(x3_rendered < middle_x){
                y3 = x3 * m3 + b3;

                x3++;
            } else {
                y3 = x3 * m3 + b3;

                x3--;
            }


            g.setColor(Color.WHITE);
            g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
            g.drawLine((int) x2, (int) y2, (int) x3, (int) y3);
            g.drawLine((int) x3, (int) y3, (int) x1, (int) y1);
        }
    }
}
