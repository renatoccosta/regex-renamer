/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.renatoccosta.renamer.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author renato
 */
public class FileUtil {

    /**
     * Compara as data de modificação de arquivos. Os arquivos que estiverem em
     * pastas de níveis diferentes serão comparados pela sua proximidade da raiz.
     */
    private static Comparator<String> compFileDate = new Comparator<String>() {

        public int compare(String o1, String o2) {
            int depth1 = o1.split(File.separator).length;
            int depth2 = o2.split(File.separator).length;

            if (depth1 > depth2) {
                return 1;
            } else if (depth2 > depth1) {
                return -1;
            } else {
                File f1 = new File(o1);
                File f2 = new File(o2);

                return (f1.lastModified() < f2.lastModified()
                        ? -1 : (f1.lastModified() == f2.lastModified() ? 0 : 1));
            }
        }

    };

    /**
     * Varre todos os arquivos da pasta e opcionalmente as subpastas e preenche
     * o array de arquivos com seus respectivos nomes completos.
     *
     * @param folder Pasta a ser varrida
     * @param includeSubFolders Fazer a leitura nas subpastas
     * @return Lista com todos os arquivos da pasta (e subpastas).
     */
    public static List<String> flattenFiles(File folder,
            boolean includeSubFolders) {
        List<String> files = new ArrayList<String>();
        flattenFiles(folder, includeSubFolders, files);
        return files;
    }

    /**
     * Método recursivo que varre os arquivos da pasta e subpastas, adicionando
     * o nome completo na lista.
     *
     * @param folder Pasta a ser varrida
     * @param includeSubFolders Fazer a leitura nas subpastas
     * @param files Lista preenchida com o nome dos arquivos
     */
    private static void flattenFiles(File folder, boolean includeSubFolders,
            List<String> files) {
        if (folder.isDirectory()) {
            for (File arq : folder.listFiles()) {
                if (arq.isFile() || includeSubFolders) {
                    flattenFiles(arq, includeSubFolders, files);
                }
            }
        } else {
            files.add(folder.getAbsolutePath());
        }
    }

    /**
     * Ordena a lista por ordem alfabética crescente pelo nome dos arquivos.
     * O nome deve ser completo.
     *
     * @param files Lista dos arquivos
     */
    public static void sortFilesByName(List<String> files) {
        Collections.sort(files);
    }

    /**
     * Ordena a lista por data de modificação crescente do arquivos.
     * O nome dos arquivos deve ser completo.
     *
     * @param files Lista dos arquivos
     */
    public static void sortFilesByDate(List<String> files) {
        Collections.sort(files, compFileDate);
    }

}
