public class triangle {
    private double[] x_3d = new double[3];
    private double[] y_3d = new double[3];
    private double[] z_3d = new double[3];

    private double[] x_2d = new double[3];
    private double[] y_2d = new double[3];

    public double getX_3d(int index) {
        return x_3d[index];
    }
    public double getY_3d(int index) {
        return y_3d[index];
    }
    public double getZ_3d(int index) {
        return z_3d[index];
    }

    public void setX_3d(double[] x_3d) {
        this.x_3d = x_3d;
    }
    public void setY_3d(double[] y_3d) {
        this.y_3d = y_3d;
    }
    public void setZ_3d(double[] z_3d) {
        this.z_3d = z_3d;
    }

    public double getX_2d(int index) {
        return x_2d[index];
    }
    public double getY_2d(int index) {
        return y_2d[index];
    }

    public void setX_2d(double[] x_2d) {
        this.x_2d = x_2d;
    }
    public void setY_2d(double[] y_2d) {
        this.y_2d = y_2d;
    }
}
