package persistencia;

import java.util.List;

import modelo.Empregado;

public interface  DAO<T> {

	void inserir(T e);

	void excluir(T e);

	List<T> listar(int limit, int offset);

	void Alterar(T e);

}