/**
 * Copyright 2009 Renato Couto da Costa
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.renatoccosta.regexrenamer.util;

import br.com.renatoccosta.regexrenamer.RenamedFile;
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
     * Compara os nomes dos arquivos. Os arquivos que estiverem em pastas de
     * níveis diferentes serão comparados pela sua proximidade da raiz.
     */
    private static Comparator<RenamedFile> compFileName =
            new Comparator<RenamedFile>() {

                public int compare(RenamedFile o1, RenamedFile o2) {
                    int depth1 = o1.getFileNameBefore().split(
                            "\\" + File.separator).length;
                    int depth2 = o2.getFileNameBefore().split(
                            "\\" + File.separator).length;

                    if (depth1 > depth2) {
                        return 1;
                    } else if (depth2 > depth1) {
                        return -1;
                    } else {
                        return o1.getFileNameBefore().compareTo(
                                o2.getFileNameBefore());
                    }
                }

            };

    /**
     * Compara as data de modificação de arquivos. Os arquivos que estiverem em
     * pastas de níveis diferentes serão comparados pela sua proximidade da raiz.
     */
    private static Comparator<RenamedFile> compFileDate =
            new Comparator<RenamedFile>() {

                public int compare(RenamedFile o1, RenamedFile o2) {
                    int depth1 = o1.getFileNameBefore().split(
                            "\\" + File.separator).length;
                    int depth2 = o2.getFileNameBefore().split(
                            "\\" + File.separator).length;

                    if (depth1 > depth2) {
                        return 1;
                    } else if (depth2 > depth1) {
                        return -1;
                    } else {
                        File f1 = new File(o1.getFileNameBefore());
                        File f2 = new File(o2.getFileNameBefore());

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
    public static void sortFilesByName(List<RenamedFile> files) {
        Collections.sort(files, compFileName);
    }

    /**
     * Ordena a lista por data de modificação crescente do arquivos.
     * O nome dos arquivos deve ser completo.
     *
     * @param files Lista dos arquivos
     */
    public static void sortFilesByDate(List<RenamedFile> files) {
        Collections.sort(files, compFileDate);
    }

}
