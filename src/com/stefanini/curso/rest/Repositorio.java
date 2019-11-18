package com.stefanini.curso.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Singleton;

@Singleton
public class Repositorio {
	
	private List<Cliente> listaCliente = new ArrayList<>();
	private List<Produto> listaProduto = new ArrayList<>();
	private Map<Integer, CarrinhoCompra> mapCarrinhoCompra = new HashMap<>();
	
	
	public List<Cliente> getListaCliente() {
		return listaCliente;
	}
	
	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}
	
	public List<Produto> getListaProduto() {
		return listaProduto;
	}
	
	public Map<Integer, CarrinhoCompra> getMapCarrinhoCompra() {
		return mapCarrinhoCompra;
	}
	
	public Cliente addCliente(Cliente cliente) {
		int codigoGerado = this.listaCliente.isEmpty() ? 0: (this.listaCliente.size());
		cliente.setCodigo(++codigoGerado);
		this.listaCliente.add(cliente);
		return cliente;
	}

	public Produto addProduto(Produto produto) {
		int codigoGerado = this.listaProduto.isEmpty() ? 0: (this.listaProduto.size());
		produto.setCodigo(++codigoGerado);
		this.listaProduto.add(produto);
		return produto;
	}
	
	public Boolean excluirCliente(Integer codigo) {
		Boolean removeu = false;
		
		for (Cliente cliente : this.listaCliente) {
			if (cliente.getCodigo().equals(codigo)) {
				removeu = this.listaCliente.remove(cliente);
				break;
			}
		}
		return removeu;
	}

	public Produto alterarProduto(Integer codigo, Produto produto) {
		for (Produto p : this.listaProduto) {
			if (p.getCodigo().equals(codigo)) {
				p.setDesconto(produto.getDesconto());
				p.setNome(produto.getNome());
				p.setPreco(produto.getPreco());
				
				produto = p;
				break;
			}
		}
		return produto;
	}

	public Boolean excluirProduto(Integer codigo) {
		Boolean removeu = false;
		
		for (Produto p : this.listaProduto) {
			if (p.getCodigo().equals(codigo)) {
				removeu = this.listaProduto.remove(p);
				break;
			}
		}
		return removeu;
	}

}
