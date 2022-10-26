package controllers;

import java.util.List;

import entities.Cliente;
import helpers.ClienteHelper;
import repositories.ClienteRepository;

public class ClienteController {

	// método para realizar o cadastro de um cliente
	public void cadastrarCliente() {

		try {

			System.out.println("\nCADASTRO DE CLIENTES\n");

			Cliente cliente = new Cliente();

			cliente.setNome(ClienteHelper.lerNome());
			cliente.setEmail(ClienteHelper.lerEmail());
			cliente.setTelefone(ClienteHelper.lerTelefone());

			ClienteRepository clienteRepository = new ClienteRepository();
			clienteRepository.create(cliente);

			System.out.println("\nCliente cadastrado com sucesso.");
		} catch (Exception e) {
			System.out.println("\nErro: " + e.getMessage());
		}

	}

	public void atualizarCliente() {
		try {

			System.out.println("\nAtualização de Cliente");

			Integer idCliente = ClienteHelper.lerIdCliente();

			ClienteRepository clienteRepository = new ClienteRepository();
			Cliente cliente = clienteRepository.findById(idCliente);

			if (cliente == null) {
				System.out.println("Cliente não encontrado, verifique o ID!");
			} else {
				cliente.setNome(ClienteHelper.lerNome());
				cliente.setEmail(ClienteHelper.lerEmail());
				cliente.setTelefone(ClienteHelper.lerTelefone());
				clienteRepository.update(cliente);
				System.out.println("\nAtualização realizada com sucesso!");
			}

		} catch (Exception e) {
			System.out.println("\nErro: " + e.getMessage());
		}

	}

	public void excluirCliente() {
		try {

			System.out.println("\nExclusão de Cliente");

			Integer idCliente = ClienteHelper.lerIdCliente();

			ClienteRepository clienteRepository = new ClienteRepository();
			Cliente cliente = clienteRepository.findById(idCliente);

			if (cliente == null) {
				System.out.println("\nCliente não encontrado, verifique o ID!");
			} else {
				clienteRepository.delete(cliente);
				System.out.println("\nExclusão realizada com sucesso!");
			}

		} catch (Exception e) {
			System.out.println("\nErro: " + e.getMessage());
		}

	}

	public void consultarClientes() {
		try {

			System.out.println("\nConsulta de Clientes");

			ClienteRepository clienteRepository = new ClienteRepository();
			List<Cliente> lista = clienteRepository.findAll();

			System.out.println("\nTotal de clientes: " + lista.size());

			for (Cliente cliente : lista) {
				System.out.println("\nCLIENTE");
				System.out.println("\n==================");
				System.out.println("\nID : " + cliente.getIdCliente());
				System.out.println("\nNome : " + cliente.getNome());
				System.out.println("\nEmail : " + cliente.getEmail());
				System.out.println("\nTelefone : " + cliente.getTelefone());
				System.out.println("\n==================");

			}

		} catch (Exception e) {
			System.out.println("\nErro: " + e.getMessage());
		}

	}

}
