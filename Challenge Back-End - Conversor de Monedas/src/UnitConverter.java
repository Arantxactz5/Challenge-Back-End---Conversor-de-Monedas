import javax.swing.JOptionPane;

public class UnitConverter {
    // Definir tasas de cambio
    private static final double USD_TO_EUR = 0.85;
    private static final double USD_TO_GBP = 0.72;
    private static final double USD_TO_JPY = 109.64;
    private static final double USD_TO_KRW = 1131.40;
    private static final double USD_TO_AUD = 1.31; // Dólar Australiano
    private static final double USD_TO_CAD = 1.26; // Dólar Canadiense
    private static final double USD_TO_CNY = 6.46; // Yuan Chino
    private static final double USD_TO_INR = 74.38; // Rupia India
    private static final double USD_TO_CHF = 0.91; // Franco Suizo

    public static void main(String[] args) {
        boolean continuar = true;
        while (continuar) {
            // Menú principal
            String[] opciones = {"Convertir moneda", "Salir"};
            int opcionMenu = JOptionPane.showOptionDialog(
                    null,
                    "¿Qué desea hacer?",
                    "Menú Principal",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);

            switch (opcionMenu) {
                case 0:
                    convertirMoneda();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Programa Finalizado", "Adiós", JOptionPane.INFORMATION_MESSAGE);
                    continuar = false;
                    break;
            }
        }
    }

    public static void convertirMoneda() {
        // Solicitar y validar la cantidad de dinero
        double cantidad = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            String cantidadStr = JOptionPane.showInputDialog(null, "Ingrese la cantidad de dinero:", "Convertir Moneda", JOptionPane.PLAIN_MESSAGE);
            try {
                cantidad = Double.parseDouble(cantidadStr);
                entradaValida = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor numérico válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Selección de moneda origen
        String[] opcionesOrigen = {"Dólar", "Euro", "Libra Esterlina", "Yen Japonés", "Won Surcoreano", "Dólar Australiano", "Dólar Canadiense", "Yuan Chino", "Rupia India", "Franco Suizo"};
        String monedaOrigen = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la moneda de origen:",
                "Convertir Moneda",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesOrigen,
                opcionesOrigen[0]);

        // Selección de moneda destino
        String[] opcionesDestino = {"Dólar", "Euro", "Libra Esterlina", "Yen Japonés", "Won Surcoreano", "Dólar Australiano", "Dólar Canadiense", "Yuan Chino", "Rupia India", "Franco Suizo"};
        String monedaDestino = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la moneda de destino:",
                "Convertir Moneda",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesDestino,
                opcionesDestino[0]);

        // Realizar la conversión
        double resultado = 0;
        switch (monedaOrigen) {
            case "Dólar":
                resultado = fromUSD(cantidad, monedaDestino);
                break;
            case "Euro":
                resultado = toUSD(cantidad, "EUR");
                resultado = fromUSD(resultado, monedaDestino);
                break;
            case "Libra Esterlina":
                resultado = toUSD(cantidad, "GBP");
                resultado = fromUSD(resultado, monedaDestino);
                break;
            case "Yen Japonés":
                resultado = toUSD(cantidad, "JPY");
                resultado = fromUSD(resultado, monedaDestino);
                break;
            case "Won Surcoreano":
                resultado = toUSD(cantidad, "KRW");
                resultado = fromUSD(resultado, monedaDestino);
                break;
            case "Dólar Australiano":
                resultado = toUSD(cantidad, "AUD");
                resultado = fromUSD(resultado, monedaDestino);
                break;
            case "Dólar Canadiense":
                resultado = toUSD(cantidad, "CAD");
                resultado = fromUSD(resultado, monedaDestino);
                break;
            case "Yuan Chino":
                resultado = toUSD(cantidad, "CNY");
                resultado = fromUSD(resultado, monedaDestino);
                break;
            case "Rupia India":
                resultado = toUSD(cantidad, "INR");
                resultado = fromUSD(resultado, monedaDestino);
                break;
            case "Franco Suizo":
                resultado = toUSD(cantidad, "CHF");
                resultado = fromUSD(resultado, monedaDestino);
                break;
        }

        // Mostrar resultado
        JOptionPane.showMessageDialog(null, "Resultado de la conversión: " + resultado + " " + monedaDestino, "Convertir Moneda", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método para convertir de la moneda de tu país a dólar
    public static double toUSD(double amount, String currency) {
        switch (currency) {
            case "EUR":
                return amount / USD_TO_EUR;
            case "GBP":
                return amount / USD_TO_GBP;
            case "JPY":
                return amount / USD_TO_JPY;
            case "KRW":
                return amount / USD_TO_KRW;
            case "AUD":
                return amount / USD_TO_AUD;
            case "CAD":
                return amount / USD_TO_CAD;
            case "CNY":
                return amount / USD_TO_CNY;
            case "INR":
                return amount / USD_TO_INR;
            case "CHF":
                return amount / USD_TO_CHF;
            default:
                return amount; // Si es dólar, simplemente devolver el mismo monto
        }
    }

    // Método para convertir de dólar a la moneda de tu país
    public static double fromUSD(double amount, String currency) {
        switch (currency) {
            case "EUR":
                return amount * USD_TO_EUR;
            case "GBP":
                return amount * USD_TO_GBP;
            case "JPY":
                return amount * USD_TO_JPY;
            case "KRW":
                return amount * USD_TO_KRW;
            case "AUD":
                return amount * USD_TO_AUD;
            case "CAD":
                return amount * USD_TO_CAD;
            case "CNY":
                return amount * USD_TO_CNY;
            case "INR":
                return amount * USD_TO_INR;
            case "CHF":
                return amount * USD_TO_CHF;
            default:
                return amount; // Si es dólar, simplemente devolver el mismo monto
        }
    }
}
