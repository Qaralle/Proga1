class lab0{
    public static void main(String[] args) {
        int k=2;
        long[] c = new long[18];
        for (int i = 0; i < 18; i++) {
            c[i]=k;
            k++;
        }
        float[] x = new float[15];
        float min = -12.0F;
        float max = 15.0F;
        for (int i=0; i<15; i++) {
            x[i]= tiparandom(min,max);
        }
        double [][] u = new double [18][15];
        for (int i = 0; i < u.length; i++) {
            for (int j = 0; j < u[i].length; j++) {
                if (c[i] == 15) { //Можно использовать Switch, однако он работает только с аргументом int, преоброзовывать не стал
                    //Math.toDegrees и Math.toRadians для того, что бы привести к стандартному, привычному виду
                    u[i][j]= Math.pow(Math.E, Math.pow((1./3)*(Math.sin(Math.toRadians(x[j]))-0.5),2));
                }
                else if ((c[i] == 2) | (c[i] == 3) | (c[i] == 5) | (c[i] == 7) | (c[i] == 8) | (c[i] == 9) | (c[i] == 17) | (c[i] == 18) | (c[i] == 19))  {
                    u[i][j] = Math.pow(Math.toDegrees(Math.asin((x[j]+1.5)/27))/2 , Math.PI/x[j]) -0.5;
                }
                else {
                    u[i][j] = Math.pow(((Math.toDegrees(Math.atan(Math.sin(Math.toRadians(Math.tan(Math.toRadians(Math.pow(Math.E, x[j]))))))))/3)/4 , 2);
                }
            }
        }
        for (int i = 0; i < u.length; i++) {
            for (int j = 0; j < u[i].length; j++) {
				if (u[i][j] < 0.001) {
                System.out.printf("%11.3e", u[i][j]);//избегаю нулей 
				}
                //13-для расстояния между столбцами , 3 для 3 цифр после запятой
				else {
                System.out.printf("%11.3f", u[i][j]);
				}
            }
            System.out.println();
        }
    }
    //рандом метод для улучшения чтения кода
    public static float tiparandom(float min, float max){
        max -= min;
        return (float) (Math.random() * ++max) + min;
    }
}

