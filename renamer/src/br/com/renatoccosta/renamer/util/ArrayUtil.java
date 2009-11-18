package br.com.renatoccosta.renamer.util;

import br.com.renatoccosta.renamer.i18n.Messages;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Renato Costa
 */
public class ArrayUtil {

    public static <T> List<T> moveBlock(List<T> source, int padding, 
            int startIdx, int endIdx) {
        int newStart = startIdx + padding;
        int newEnd = endIdx + padding;

        //valida os limites
        if (newStart < 0 || newEnd > source.size() - 1) {
            throw new IndexOutOfBoundsException(
                    Messages.getOutOfBoundsMessage());
        }

        List dest = new ArrayList();

        //preenche o novo array sem o elementos a serem deslocados
        for (int i = 0; i < source.size(); i++) {
            if (i < startIdx || i > endIdx) {
                dest.add(source.get(i));
            }
        }

        //adiciona os elementos deslocados nas posições de destino
        for (int i = startIdx; i <= endIdx; i++) {
            dest.add(i + padding, source.get(i));
        }

        return dest;
    }

}
