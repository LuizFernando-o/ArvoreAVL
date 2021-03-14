package arvoreavl;

public class ArvoreBinariaDePesquisa extends AbstractArvoreBinariaDePesquisa<No> {

    @Override
    public No novoNode(int key) {
        return new No(key);
    }

    @Override
    public No inserir(int key) {
        No n = inserirNoHelper(raiz, key);
        verificaBalanceia(n);
        return n;
    }

    private void verificaBalanceia(No n) {
        atualizarFator(n);

        if (n.getFator() != 0) {
            if (n.getFator() > 1) {
                if (n.getDireita().getFator() >= 1) {
                    n = rotacaoEsquerda(n);
                } else {
                    n = rotacaoDireitaEsquerda(n.getDireita());
                }
            } else if (n.getFator() < -1) {
                if (n.getEsquerda().getFator() >= 1) {
                    n = rotacaoEsquerdaDireita(n.getEsquerda());
                } else {
                    n = rotacaoDireita(n);
                }
            }
        }

        if (n != raiz) {
            verificaBalanceia(n.getPai());
        } else {
            raiz = n;
        }
    }

    // Rotaçao à Esquerda
    private No rotacaoEsquerda(No n) {
        No auxDir = n.getDireita();
        // Pai de 'n' vira o pai de auxDir 
        auxDir.setPai(n.getPai());
        // Subarvore a esquerda de auxDir vira subarvore a direita de 'n'
        n.setDireita(auxDir.getEsquerda());
        if (n.getDireita() != null) {
            n.getDireita().setPai(n);
        }
        // Pai de 'n' vira auxDir
        auxDir.setEsquerda(n);
        n.setPai(auxDir);

        if (auxDir.getPai() != null) {
            if (auxDir.getPai().getDireita() == n) {
                auxDir.getPai().setDireita(auxDir);
            } else if (auxDir.getPai().getEsquerda() == n) {
                auxDir.getPai().setEsquerda(auxDir);
            }
        }

        if (n == raiz) {
            raiz = auxDir;
        }

        // Atualiza fatores de balanceamento
        atualizarFator(n);
        atualizarFator(auxDir);
        return auxDir;
    }

    // Rotaçao à Direira
    private No rotacaoDireita(No n) {
        No auxEsq = n.getEsquerda();
        // Pai de 'n' vira o pai de auxDir 
        auxEsq.setPai(n.getPai());
        // Subarvore a esquerda de auxDir vira subarvore a direita de 'n'
        n.setEsquerda(auxEsq.getDireita());
        if (n.getEsquerda() != null) {
            n.getEsquerda().setPai(n);
        }
        // Pai de 'n' vira auxDir
        auxEsq.setDireita(n);
        n.setPai(auxEsq);

        if (auxEsq.getPai() != null) {
            if (auxEsq.getPai().getEsquerda() == n) {
                auxEsq.getPai().setEsquerda(auxEsq);
            } else if (auxEsq.getPai().getDireita() == n) {
                auxEsq.getPai().setDireita(auxEsq);
            }
        }

        if (n == raiz) {
            raiz = auxEsq;
        }

        // Atualiza fatores de balanceamento
        atualizarFator(n);
        atualizarFator(auxEsq);
        return auxEsq;
    }

    private No rotacaoEsquerdaDireita(No n) {
        No aux = rotacaoEsquerda(n);
        return rotacaoDireita(aux.getPai());
    }

    private No rotacaoDireitaEsquerda(No n) {
        No aux = rotacaoDireita(n);
        return rotacaoEsquerda(aux.getPai());
    }

    private void atualizarFator(No n) {
        int hd = retornaAltura(n.getDireita());
        int he = retornaAltura(n.getEsquerda());
        n.setFator(hd - he);
    }

    private int retornaAltura(No n) {
        if (n == null) {
            return -1;
        }
        if (n.getEsquerda() == null && n.getDireita() == null) {
            return 0;
        } else if (n.getEsquerda() == null) {
            return 1 + retornaAltura(n.getDireita());
        } else if (n.getDireita() == null) {
            return 1 + retornaAltura(n.getEsquerda());
        } else {
            return 1 + Math.max(retornaAltura(n.getEsquerda()), retornaAltura(n.getDireita()));
        }
    }

    @Override
    public No procurar(int key) {
        return procurarNoHelper(raiz, key);
    }

    @Override
    public No deletar(int key) {
        // ao tentar deletar todos os nos -> nao deleta um
        // quando o no a ser deletado tem dois filhos, a troca nao é correta
        // quando o no a ser deletado é a raiz, e tem varios filhos, o escolhido a ser a nova raiz não é correto
        //deletando a raiz e ela nao tem filhos? aparece a raiz mesmo estando null
        No n;
        if(raiz.getChave() == key && retornaAltura(raiz)==0){
            n = deletarNoHelper(raiz, key);
        }else{
            n = deletarNoHelper(raiz, key);
            verificaBalanceia(n);
        }
        return n;
    }
}
