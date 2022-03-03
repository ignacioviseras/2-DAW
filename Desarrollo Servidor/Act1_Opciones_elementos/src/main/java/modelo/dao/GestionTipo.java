package modelo.dao;

import java.util.ArrayList;
import java.util.List;


import modelo.beans.Tipo;

public class GestionTipo implements InterfTipo{
	List<Tipo> list;
	
	public GestionTipo() {
		list = new ArrayList<Tipo>();
		cargarTipo();
		
	}
	private void cargarTipo() {
		list.add(new Tipo(1, "Cumple", "Celebracion del dia en que naciste"));
		list.add(new Tipo(2, "Boda", "Celebracion de la union de 2 personas"));
		list.add(new Tipo(3, "Comunion", "Celebracion cristiana del momento en el que se acepta a dios"));
		list.add(new Tipo(4, "Despedida", "Fiesta para despedir a algui por cualquier motivo"));

	}
	@Override
	public List<Tipo> findAll() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Tipo findById(long id) {
		Tipo tipo = new Tipo();
		tipo.setID(id);
		
		int pos = list.indexOf(tipo);
		if(pos == -1)
			return null;
		else
			return list.get(pos);
	}

	@Override
	public int insertOne(Tipo Tipo) {
		if(!list.contains(Tipo)) {//si el evento que nos pasan no esta en la lista 
			list.add(Tipo);//lo añadimos
			return 1;
		}else
			return 0;//si no no hacemos nada
	}

	@Override
	public int deleteOne(long id) {
		Tipo tipo = findById(id);
		if(tipo == null) {
			return 0;
		}else
			return list.remove(tipo)?1:0;
	}

}
