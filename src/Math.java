public class Math {
    public triangle projectionMatrix(triangle tris){
        triangle tri = new triangle();

        double[] x = new double[3];
        double[] y = new double[3];

        x[0] = 1 * tris.getX_3d(0) + 0 * tris.getY_3d(0) + 0 * tris.getZ_3d(0);
        x[1] = 1 * tris.getX_3d(1) + 0 * tris.getY_3d(1) + 0 * tris.getZ_3d(1);
        x[2] = 1 * tris.getX_3d(2) + 0 * tris.getY_3d(2) + 0 * tris.getZ_3d(2);

        y[0] = 0 * tris.getX_3d(0) + 1 * tris.getY_3d(0) + 0 * tris.getZ_3d(0);
        y[1] = 0 * tris.getX_3d(1) + 1 * tris.getY_3d(1) + 0 * tris.getZ_3d(1);
        y[2] = 0 * tris.getX_3d(2) + 1 * tris.getY_3d(2) + 0 * tris.getZ_3d(2);

        tri.setX_2d(x);
        tri.setY_2d(y);

        return tri;
    }

    public triangle rotationMatrixZ(double angle, triangle tris){
        triangle tri = new triangle();

        double[] x = new double[3];
        double[] y = new double[3];
        double[] z = new double[3];

        x[0] = java.lang.Math.cos(angle) * tris.getX_3d(0) + (-1 * java.lang.Math.sin(angle)) * tris.getY_3d(0) + 0 * tris.getZ_3d(0);
        x[1] = java.lang.Math.cos(angle) * tris.getX_3d(1) + (-1 * java.lang.Math.sin(angle)) * tris.getY_3d(1) + 0 * tris.getZ_3d(1);
        x[2] = java.lang.Math.cos(angle) * tris.getX_3d(2) + (-1 * java.lang.Math.sin(angle)) * tris.getY_3d(2) + 0 * tris.getZ_3d(2);

        y[0] = java.lang.Math.sin(angle) * tris.getX_3d(0) + java.lang.Math.cos(angle) * tris.getY_3d(0) + 0 * tris.getZ_3d(0);
        y[1] = java.lang.Math.sin(angle) * tris.getX_3d(1) + java.lang.Math.cos(angle) * tris.getY_3d(1) + 0 * tris.getZ_3d(1);
        y[2] = java.lang.Math.sin(angle) * tris.getX_3d(2) + java.lang.Math.cos(angle) * tris.getY_3d(2) + 0 * tris.getZ_3d(2);

        z[0] = 0 * tris.getX_3d(0) + 0 * tris.getY_3d(0) + 1 * tris.getZ_3d(0);
        z[1] = 0 * tris.getX_3d(1) + 0 * tris.getY_3d(1) + 1 * tris.getZ_3d(1);
        z[2] = 0 * tris.getX_3d(2) + 0 * tris.getY_3d(2) + 1 * tris.getZ_3d(2);

        tri.setX_3d(x);
        tri.setY_3d(y);
        tri.setZ_3d(z);

        return tri;
    }

    public triangle rotationMatrixY(double angle, triangle tris){
        triangle tri = new triangle();

        double[] x = new double[3];
        double[] y = new double[3];
        double[] z = new double[3];

        x[1] = java.lang.Math.cos(angle) * tris.getX_3d(1) + 0 * tris.getY_3d(1) + java.lang.Math.sin(angle) * tris.getZ_3d(1);
        x[2] = java.lang.Math.cos(angle) * tris.getX_3d(2) + 0 * tris.getY_3d(2) + java.lang.Math.sin(angle) * tris.getZ_3d(2);
        x[0] = java.lang.Math.cos(angle) * tris.getX_3d(0) + 0 * tris.getY_3d(0) + java.lang.Math.sin(angle) * tris.getZ_3d(0);

        y[0] = 0 * tris.getX_3d(0) + 1 * tris.getY_3d(0) + 0 * tris.getZ_3d(0);
        y[1] = 0 * tris.getX_3d(1) + 1 * tris.getY_3d(1) + 0 * tris.getZ_3d(1);
        y[2] = 0 * tris.getX_3d(2) + 1 * tris.getY_3d(2) + 0 * tris.getZ_3d(2);

        z[0] = (-1 * java.lang.Math.sin(angle)) * tris.getX_3d(0) + 0 * tris.getY_3d(0) +  java.lang.Math.cos(angle) * tris.getZ_3d(0);
        z[1] = (-1 * java.lang.Math.sin(angle)) * tris.getX_3d(1) + 0 * tris.getY_3d(1) +  java.lang.Math.cos(angle) * tris.getZ_3d(1);
        z[2] = (-1 * java.lang.Math.sin(angle)) * tris.getX_3d(2) + 0 * tris.getY_3d(2) +  java.lang.Math.cos(angle) * tris.getZ_3d(2);

        tri.setX_3d(x);
        tri.setY_3d(y);
        tri.setZ_3d(z);

        return tri;
    }

    public triangle rotationMatrixX(double angle, triangle tris){
        triangle tri = new triangle();

        double[] x = new double[3];
        double[] y = new double[3];
        double[] z = new double[3];

        x[0] = 1 * tris.getX_3d(0) + 0 * tris.getY_3d(0) + 0 * tris.getZ_3d(0);
        x[1] = 1 * tris.getX_3d(1) + 0 * tris.getY_3d(1) + 0 * tris.getZ_3d(1);
        x[2] = 1 * tris.getX_3d(2) + 0 * tris.getY_3d(2) + 0 * tris.getZ_3d(2);

        y[0] = 0 * tris.getX_3d(0) +  java.lang.Math.cos(angle) * tris.getY_3d(0) +  (-1 * java.lang.Math.sin(angle)) * tris.getZ_3d(0);
        y[1] = 0 * tris.getX_3d(1) +  java.lang.Math.cos(angle) * tris.getY_3d(1) +  (-1 * java.lang.Math.sin(angle)) * tris.getZ_3d(1);
        y[2] = 0 * tris.getX_3d(2) +  java.lang.Math.cos(angle) * tris.getY_3d(2) +  (-1 * java.lang.Math.sin(angle)) * tris.getZ_3d(2);

        z[0] = 0 * tris.getX_3d(0) +  java.lang.Math.sin(angle) * tris.getZ_3d(0) +  java.lang.Math.cos(angle) * tris.getZ_3d(0);
        z[1] = 0 * tris.getX_3d(1) +  java.lang.Math.sin(angle) * tris.getZ_3d(1) +  java.lang.Math.cos(angle) * tris.getZ_3d(1);
        z[2] = 0 * tris.getX_3d(2) +  java.lang.Math.sin(angle) * tris.getZ_3d(2) +  java.lang.Math.cos(angle) * tris.getZ_3d(2);

        tri.setX_3d(x);
        tri.setY_3d(y);
        tri.setZ_3d(z);

        return tri;
    }
}
