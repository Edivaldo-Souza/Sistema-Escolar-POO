package br.edu.ufersa.SistemaEscolar.model.services;

public interface InterfaceServices<type> {
	public boolean insert(type entity);
	public boolean delete(type entity);
	public boolean alter(type entity);
}
