package aplicacao;

import entidade.Prato;
import util.StaticFilter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        Object[] options = {"Sim", "Não"};

        List<Prato> pratosSalgados = new ArrayList<>();
        List<Prato> pratosDoces = new ArrayList<>();

        for (int i = 0; i <= 0; i--){
            program(frame, options, pratosSalgados, pratosDoces);
        }

    }

    private static void program(JFrame frame, Object[] options, List<Prato> pratosSalgados, List<Prato> pratosDoces) {
        JOptionPane.showConfirmDialog(frame, StaticFilter.PRATO_QUE_GOSTA, StaticFilter.JOGO_UNIMED_FOTALEZA, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null);

        int massa = JOptionPane.showOptionDialog(frame, StaticFilter.PRATO_MASSA, StaticFilter.CONFIRM, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (massa == JOptionPane.YES_NO_OPTION) {
            if (pratosSalgados.size() > 0) {
                logicaIA(frame, options, pratosSalgados, StaticFilter.PRATO_MASSA);
            }

            int lasanha = JOptionPane.showOptionDialog(frame, StaticFilter.PRATO_LASANHA, StaticFilter.CONFIRM, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            if (lasanha == JOptionPane.YES_NO_OPTION) {
                acerteiDeNovo(frame);
            } else {
                adicionarNovoPrato(frame, pratosSalgados, StaticFilter.PRATO_MASSA);
            }
        } else {
            if (pratosDoces.size() > 0) {
                logicaIA(frame, options, pratosDoces, StaticFilter.PRATO_BOLO_DE_CHOCOLATE);
            }

            int boloChocolate = JOptionPane.showOptionDialog(frame, StaticFilter.PRATO_BOLO_DE_CHOCOLATE, StaticFilter.CONFIRM, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            if (boloChocolate == JOptionPane.YES_NO_OPTION) {
                acerteiDeNovo(frame);
            } else {
                adicionarNovoPrato(frame, pratosDoces, StaticFilter.PRATO_BOLO_DE_CHOCOLATE);
            }
        }
    }

    private static void logicaIA(JFrame frame, Object[] options, List<Prato> pratos, String filter) {
        for (Prato listaPratos : pratos) {
            int resposta = JOptionPane.showOptionDialog(frame, StaticFilter.PRATO_QUE_PENSOU + listaPratos.getAdjetivo(), StaticFilter.CONFIRM, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (resposta == JOptionPane.YES_NO_OPTION) {
                int eEsse = JOptionPane.showOptionDialog(frame, StaticFilter.PRATO_QUE_PENSOU + listaPratos.getNome(), StaticFilter.CONFIRM, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if (eEsse == JOptionPane.YES_NO_OPTION) {
                    acerteiDeNovo(frame);
                } else {
                    adicionarNovoPrato(frame, pratos, filter);
                }
            }
        }
    }

    private static void acerteiDeNovo(Frame frame) {
        JOptionPane.showConfirmDialog(frame, StaticFilter.ACERTEI, StaticFilter.JOGO_GOURMET, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
    }

    private static void adicionarNovoPrato(Frame frame, List<Prato> pratos, String filter) {
        String nome = JOptionPane.showInputDialog(frame, StaticFilter.QUAL_PRATO_QUE_PENSOU, StaticFilter.DESISTO, JOptionPane.QUESTION_MESSAGE);
        String adjetivo;

        if (filter.equals(StaticFilter.PRATO_MASSA)){
            adjetivo = JOptionPane.showInputDialog(frame, nome + StaticFilter.COMPLETE_ADJETIVO_LASANHA, StaticFilter.COMPLETE, JOptionPane.QUESTION_MESSAGE);
        }else {
            adjetivo = JOptionPane.showInputDialog(frame, nome + StaticFilter.COMPLETE_ADJETIVO_BOLO, StaticFilter.COMPLETE, JOptionPane.QUESTION_MESSAGE);
        }

        pratos.add(new Prato(nome, adjetivo));
    }
}
