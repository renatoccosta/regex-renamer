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

import br.com.renatoccosta.regexrenamer.i18n.Messages;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Renato Costa
 */
public class ArrayUtil {

    public static <T> void moveBlock(List<T> source, int padding,
            int[] selectedIndexes) {

        if (selectedIndexes.length == 0) {
            throw new IllegalArgumentException();
        }

        int newStart = selectedIndexes[0] + padding;
        int newEnd = selectedIndexes[selectedIndexes.length - 1] + padding;

        //valida os limites
        if (newStart < 0 || newEnd > source.size() - 1) {
            throw new IndexOutOfBoundsException(
                    Messages.getOutOfBoundsMessage());
        }

        List<T> dest = new ArrayList<T>();

        //preenche o novo array sem o elementos a serem deslocados
        for (int i = 0; i < source.size(); i++) {
            boolean add = true;

            for (int j : selectedIndexes) {
                if (i==j) {
                    add = false;
                    break;
                } else if (i < j) {
                    break;
                }
            }

            if (add) {
                dest.add(source.get(i));
            }
        }

        //adiciona os elementos deslocados nas posições de destino
        for (int idx : selectedIndexes) {
            dest.add(idx + padding, source.get(idx));
        }

        source.clear();
        source.addAll(dest);
    }

}
