package pieza;

import java.util.Scanner;

/**
 *
 * @author Juan Catrileo / Javier Vergara
 */
public class Pieza {

    Scanner input = new Scanner(System.in);

    int PORCENTAJE_GATOS;
    int PORCENTAJE_RATONES;

    short MAXIMO = 20;

    Item[][] mPieza;

    public Pieza() {
    }

    public void mensajeBienvenida() {
        System.out.println("-------------------------------");
        System.out.println("Bienvenido al creador de planos");
        System.out.println("-------------------------------");
        System.out.println("Regla: Todo lo que sea coordenada");
        System.out.println("Se debe ingresar soparado por una");
        System.out.println("coma. EJ: 1,4");
        System.out.println("-------------------------------");
    }

    public void setmPieza() {
        int x;
        int y;

        while (true) {
            while (true) {
                try {
                    String coord;
                    String[] parte;

                    System.out.print("Ingrese alto y ancho de la pieza: ");
                    coord = input.nextLine();
                    parte = coord.split(",");
                    x = Integer.parseInt(parte[0]);
                    y = Integer.parseInt(parte[1]);

                    if (x > MAXIMO || y > MAXIMO) {
                        System.out.println("El alto y/o ancho de la pieza no puede "
                                + "ser mayor a 20.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Ingrese sólo números.");
                } catch (ArrayIndexOutOfBoundsException ex2) {
                    System.out.println("Coordenadas inválidas.");
                }
            }

            try {
                this.mPieza = new Item[x][y];
                break;
            } catch (NegativeArraySizeException ex) {
                System.out.println("Ingrese sólo coordenadas positivas.");
            }
        }

        for (int i = 0; i < this.mPieza.length; i++) {
            for (int j = 0; j < this.mPieza[i].length; j++) {
                this.mPieza[i][j] = new Vacio();
            }
        }

        this.PORCENTAJE_GATOS = (x * y) / 10;
        this.PORCENTAJE_RATONES = (x * y) * 25 / 100;
    }

    public void getmPieza() {

        for (int i = 0; i < this.mPieza.length; i++) {
            if (i == 0) {
                System.out.print("f/c ");
            }

            boolean salir = false;

            for (int j = 0; j < mPieza[i].length; j++) {
                if ((j + 1) <= 10) {
                    System.out.print("0" + j + " ");
                } else {
                    System.out.print(j + " ");
                }

                salir = true;
            }

            System.out.println();

            if (salir == true) {
                break;
            }
        }

        for (int i = 0; i < this.mPieza.length; i++) {
            if ((i + 1) <= 10) {
                System.out.print(" 0" + i + " ");
            } else {
                System.out.print(" " + i + " ");
            }

            for (int j = 0; j < this.mPieza[i].length; j++) {
                System.out.print(" " + mPieza[i][j] + " ");
            }

            System.out.println();
        }
    }

    private void getMuebleX() {
        for (int i = 0; i < this.mPieza.length; i++) {
            if (i == 0) {
                System.out.print("f/c ");
            }

            boolean salir = false;

            for (int j = 0; j < mPieza[i].length; j++) {
                if ((j + 1) <= 10) {
                    System.out.print("0" + j + " ");
                } else {
                    System.out.print(j + " ");
                }

                salir = true;
            }

            System.out.println();

            if (salir == true) {
                break;
            }
        }

        for (int i = 0; i < this.mPieza.length; i++) {
            if ((i + 1) <= 10) {
                System.out.print(" 0" + i + " ");
            } else {
                System.out.print(" " + i + " ");
            }

            for (int j = 0; j < this.mPieza[i].length; j++) {
                if (mPieza[i][j].getClass() == Mueble.class) {
                    System.out.print(" X ");
                } else {
                    System.out.print(" " + mPieza[i][j] + " ");
                }
            }

            System.out.println();
        }

    }

    public void setGato() {
        while (true) {
            if (this.PORCENTAJE_GATOS <= 0) {
                System.out.println("No puede ingresar gatos.");
                break;
            }

            int cantidad;

            while (true) {
                while (true) {
                    System.out.println("Sólo puede ingresar " + "[" + this.PORCENTAJE_GATOS
                            + "]" + " gatos como máximo.");
                    System.out.print("N° de Gatos: ");

                    try {
                        cantidad = Integer.parseInt(input.nextLine());
                        break;
                    } catch (NumberFormatException ex) {
                        System.out.println("Ingrese sólo números.");
                    }
                }

                if (cantidad > 0) {
                    getmPieza();
                }

                break;
            }

            if (cantidad > this.PORCENTAJE_GATOS) {
                System.out.println("No puede ingresar más de " + "["
                        + this.PORCENTAJE_GATOS + "]" + " gatos.");
                continue;
            } else if (cantidad < 0) {
                System.out.println("La cantidad de gatos a ingresar no puede ser negativa.");
                continue;
            }

            for (int i = 0; i < cantidad; i++) {
                boolean exit = false;

                while (exit == false) {
                    int x;
                    int y;

                    while (true) {
                        try {
                            System.out.println("-----------------");
                            System.out.println("GATO N°" + (i + 1));
                            System.out.println("-----------------");
                            System.out.print("Ingrese fila y columna: ");
                            String coordenadas = input.nextLine();
                            String[] parte = coordenadas.split(",");
                            x = Integer.parseInt(parte[0]);
                            y = Integer.parseInt(parte[1]);
                            break;

                        } catch (NumberFormatException ex) {
                            System.out.println("Ingrese sólo números.");
                            getmPieza();
                        } catch (ArrayIndexOutOfBoundsException ex2) {
                            System.out.println("Coordenadas inválidas.");
                            getmPieza();
                        }
                    }

                    while (true) {
                        try {
                            if (this.mPieza[x][y].getClass() == Gato.class) {
                                System.out.println("Esta coordenada ya está"
                                        + " ocupada.");
                                getmPieza();
                                break;
                            }

                            this.mPieza[x][y] = new Gato();
                            exit = true;

                            break;
                        } catch (ArrayIndexOutOfBoundsException ex) {
                            System.out.println("Coordenadas inválidas.");
                            getmPieza();
                            break;
                        }
                    }
                }

                getmPieza();
            }

            break;
        }
    }

    public void setRatones() {
        while (true) {
            if (this.PORCENTAJE_RATONES <= 0) {
                System.out.println("No puede ingresar ratones.");
                break;
            }

            int cantidad;

            while (true) {
                while (true) {
                    System.out.println("Puede ingresar " + "["
                            + this.PORCENTAJE_RATONES + "]" + " ratones como máximo.");
                    System.out.print("N° de ratones: ");

                    try {
                        cantidad = Integer.parseInt(input.nextLine());
                        break;
                    } catch (NumberFormatException ex) {
                        System.out.println("Ingrese sólo números.");
                    }
                }

                if (cantidad > 0) {
                    getmPieza();
                }

                break;
            }

            if (cantidad > this.PORCENTAJE_RATONES) {
                System.out.println("No puede ingresar más de " + "["
                        + this.PORCENTAJE_RATONES + "]" + " ratones.");
                continue;
            } else if (cantidad < 0) {
                System.out.println("La cantidad de ratones a ingresar no puede"
                        + " ser negativa");
                continue;
            }

            for (int i = 0; i < cantidad; i++) {
                boolean exit = false;

                while (exit == false) {
                    int x;
                    int y;

                    while (true) {
                        try {
                            System.out.println("-----------------");
                            System.out.println("RATÓN N°" + (i + 1));
                            System.out.println("-----------------");

                            System.out.print("Ingrese fila y columna separada por "
                                    + "un espacio: ");
                            String coordenadas = input.nextLine();
                            String[] parte = coordenadas.split(",");
                            x = Integer.parseInt(parte[0]);
                            y = Integer.parseInt(parte[1]);
                            break;
                        } catch (NumberFormatException ex) {
                            System.out.println("Ingrese sólo números.");
                            getmPieza();
                        } catch (ArrayIndexOutOfBoundsException ex2) {
                            System.out.println("Coordenadas inválidas.");
                            getmPieza();
                        }
                    }

                    while (true) {
                        try {
                            if (mPieza[x][y].getClass() == Gato.class
                                    || mPieza[x][y].getClass() == Raton.class) {
                                System.out.println("Esta coordenada ya está"
                                        + " ocupada.");
                                getmPieza();
                                break;
                            }

                            mPieza[x][y] = new Raton();
                            exit = true;
                            break;
                        } catch (ArrayIndexOutOfBoundsException ex) {
                            System.out.println("Coordenadas inválidas.");
                            getmPieza();
                            break;
                        }
                    }
                }

                getmPieza();
            }

            break;
        }
    }

    public void setMueble() {
        int cantidad;

        while (true) {
            System.out.print("N° de Muebles: ");
            try {
                cantidad = Integer.parseInt(input.nextLine());

                if (cantidad < 0) {
                    System.out.println("La cantidad de muebles no puede ser"
                            + " negativa.");
                    continue;
                }

                break;
            } catch (NumberFormatException ex) {
                System.out.println("Ingrese sólo números.");
            }
        }

        getMuebleX();

        int xSuperior = 0;
        int ySuperior = 0;

        int xInferior = 0;
        int yInferior = 0;

        for (int i = 0; i < cantidad; i++) {
            boolean exit = false;

            while (exit == false) {
                while (true) {
                    while (true) {
                        System.out.println("--------------------");
                        System.out.println("MUEBLE N° " + (i + 1));
                        System.out.println("--------------------");

                        System.out.print("Ingrese esquina superior del mueble: ");
                        String coordSuperior = input.nextLine();

                        String[] parteSuperior = coordSuperior.split(",");

                        try {
                            xSuperior = Integer.parseInt(parteSuperior[0]);
                            ySuperior = Integer.parseInt(parteSuperior[1]);

                            if (mPieza[xSuperior][ySuperior]
                                    .getClass().equals(Gato.class)
                                    || mPieza[xSuperior][ySuperior]
                                            .getClass().equals(Raton.class)
                                    || mPieza[xSuperior][ySuperior]
                                            .getClass().equals(Mueble.class)) {
                                System.out.println("Coordenada ocupada.");
                                getMuebleX();
                                continue;
                            }

                            break;
                        } catch (NumberFormatException ex) {
                            System.out.println("Ingrese sólo números "
                                    + "o números válidos.");
                        } catch (ArrayIndexOutOfBoundsException ex2) {
                            System.out.println("Coordenadas inválidas.");
                        }

                    }

                    try {
                        mPieza[xSuperior][ySuperior] = new Mueble();
                        break;
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        System.out.println("Coordenadas inválidas.");
                        getMuebleX();
                    }
                }

                getMuebleX();

                while (true) {
                    while (true) {
                        System.out.println("--------------------");
                        System.out.println("MUEBLE N° " + (i + 1));
                        System.out.println("--------------------");

                        System.out.print("Ingrese la esquina inferior derecha del mueble: ");
                        String coordInferior = input.nextLine();

                        String[] parteInferior = coordInferior.split(",");

                        try {
                            xInferior = Integer.parseInt(parteInferior[0]);
                            yInferior = Integer.parseInt(parteInferior[1]);

                            if (mPieza[xInferior][yInferior]
                                    .getClass().equals(Gato.class)
                                    || mPieza[xInferior][yInferior]
                                            .getClass().equals(Raton.class)
                                    || mPieza[xInferior][yInferior]
                                            .getClass().equals(Mueble.class)) {
                                System.out.println("Coordenada ocupada.");
                                getMuebleX();
                                continue;
                            }

                            break;
                        } catch (NumberFormatException ex) {
                            System.out.println("Ingrese sólo números.");
                            getMuebleX();
                        } catch (ArrayIndexOutOfBoundsException ex2) {
                            System.out.println("Coordenadas inválidas.");
                            getMuebleX();
                        }
                    }

                    try {
                        mPieza[xInferior][yInferior] = new Mueble();
                        break;
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        System.out.println("Coordenadas inválidas.");
                        getMuebleX();
                    }
                }

                int grCont = 0;

                for (int j = xSuperior; j <= xInferior; j++) {
                    for (int k = ySuperior; k <= yInferior; k++) {
                        if (mPieza[j][k].getClass().equals(Gato.class)
                                || mPieza[j][k].getClass().equals(Raton.class)) {
                            grCont++;
                        }
                    }
                }

                if (grCont > 0) {
                    System.out.println("Rango de coordenadas está opcupado.");
                    getMuebleX();
                    mPieza[xSuperior][ySuperior] = new Vacio();
                    mPieza[xInferior][yInferior] = new Vacio();
                    getMuebleX();
                } else {
                    getMuebleX();
                    while (true) {
                        System.out.print("¿Confirmar? (S o N): ");
                        String confirmar = input.nextLine();
                        if (confirmar.equalsIgnoreCase("s")) {
                            exit = true;
                            break;
                        } else if (confirmar.equalsIgnoreCase("n")) {
                            mPieza[xSuperior][ySuperior] = new Vacio();
                            mPieza[xInferior][yInferior] = new Vacio();
                            getMuebleX();
                            break;
                        } else {
                            System.out.println("Ingrese sólo S o N.");
                        }
                    }
                }
            }

            getMuebleX();

            for (int j = xSuperior; j <= xInferior; j++) {
                for (int k = ySuperior; k <= yInferior; k++) {
                    mPieza[j][k] = new Mueble();
                }
            }

            getmPieza();

        }
    }
}
