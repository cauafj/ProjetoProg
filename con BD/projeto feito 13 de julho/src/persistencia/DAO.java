package persistencia;

import java.util.List;

public interface  DAO<T> {

	void inserir(T e);

	void excluir(int id);

	List<T> listar(int limit, int offset);

	void alterar(T e);

	T buscar(int id);
}