
package util;

/**
 *
 * @author Jair Ferraz
 */
public class Validador {

    /**
     *
     * @param c
     * @return
     */
    public static boolean validarCadastro(String c) {
        return c.matches("[^\\ ][a-zA-Z0-9\\ ]{1,100}");
    }

    public static String removerAcentos(String c) {
        c = c.replaceAll("[ÂÀÁÄÃ]", "A");
        c = c.replaceAll("[âãàáä]", "a");
        c = c.replaceAll("[ÊÈÉË]", "E");
        c = c.replaceAll("[êèéë]", "e");
        c = c.replaceAll("ÎÍÌÏ", "I");
        c = c.replaceAll("îíìï", "i");
        c = c.replaceAll("[ÔÕÒÓÖ]", "O");
        c = c.replaceAll("[ôõòóö]", "o");
        c = c.replaceAll("[ÛÙÚÜ]", "U");
        c = c.replaceAll("[ûúùü]", "u");
        c = c.replaceAll("Ç", "C");
        c = c.replaceAll("ç", "c");
        c = c.replaceAll("[ýÿ]", "y");
        c = c.replaceAll("Ý", "Y");
        c = c.replaceAll("ñ", "n");
        c = c.replaceAll("Ñ", "N");
        return c;
    }
}
