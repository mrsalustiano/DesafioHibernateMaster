package com.qintess.DesafioHibernateMaster.Application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.qintess.DesafioHibernateMaster.DAO.GenericDAO;
import com.qintess.DesafioHibernateMaster.Model.Cerveja;
import com.qintess.DesafioHibernateMaster.Model.Cidade;
import com.qintess.DesafioHibernateMaster.Model.Cliente;
import com.qintess.DesafioHibernateMaster.Model.Estado;
import com.qintess.DesafioHibernateMaster.Model.Estilo;
import com.qintess.DesafioHibernateMaster.Model.Grupo;
import com.qintess.DesafioHibernateMaster.Model.GrupoPermissao;
import com.qintess.DesafioHibernateMaster.Model.GrupoPermissaoID;
import com.qintess.DesafioHibernateMaster.Model.ItemVenda;
import com.qintess.DesafioHibernateMaster.Model.Permissao;
import com.qintess.DesafioHibernateMaster.Model.Usuario;
import com.qintess.DesafioHibernateMaster.Model.UsuarioGrupo;
import com.qintess.DesafioHibernateMaster.Model.UsuarioGrupoID;
import com.qintess.DesafioHibernateMaster.Model.Venda;

public class App {
	public static void main(String[] args) {
		Locale.setDefault(new Locale("pt", "BR"));

		System.out.println("Cerveja e Estilo");

		Cerveja cerveja = new Cerveja();
		Cerveja cerveja1 = new Cerveja();
		Cerveja cerveja2 = new Cerveja();
		
		Estilo estilo = new Estilo();
		Estilo estilo2 = new Estilo();

		estilo.setNome("estilo1");
		estilo2.setNome("estilo2");

		cerveja.setNome("Cerveja1");
		cerveja.setDescricao("Cerveja 1 com descricao");
		cerveja.setOrigem("brasil");
		cerveja.setQuantidade_estoque(1);
		cerveja.setSabor("ipa");
		cerveja.setSku("sku");
		cerveja.setTeor_alcoolico(7.9);
		cerveja.setValor(32.99);
		cerveja.setComissao(20.10);

		// cerveja 1
		cerveja1.setNome("Cerveja2");
		cerveja1.setDescricao("Cerveja 2 com descricao");
		cerveja1.setOrigem("brasil");
		cerveja1.setQuantidade_estoque(10);
		cerveja1.setSabor("ipa");
		cerveja1.setSku("sku");
		cerveja1.setTeor_alcoolico(5.0);
		cerveja1.setValor(16.99);
		cerveja1.setComissao(20.10);

		cerveja2.setNome("Cerveja3");
		cerveja2.setDescricao("Cerveja 3 com descricao");
		cerveja2.setOrigem("brasil");
		cerveja2.setQuantidade_estoque(10);
		cerveja2.setSabor("lager");
		cerveja2.setSku("sku");
		cerveja2.setTeor_alcoolico(5.9);
		cerveja2.setValor(10.99);
		cerveja2.setComissao(20.10);

		List<Cerveja> cervejas = new ArrayList<Cerveja>();
		cervejas.add(cerveja);
		cervejas.add(cerveja1);
		cervejas.add(cerveja2);
		

		cerveja.setEstilo(estilo);
		cerveja1.setEstilo(estilo2);
		cerveja2.setEstilo(estilo);

		GenericDAO<Cerveja> daoCerveja = new GenericDAO<Cerveja>();

		daoCerveja.salvar(cerveja);
		daoCerveja.salvar(cerveja1);
		daoCerveja.salvar(cerveja2);
		
		
		System.out.println("Fim Cerveja e estilo");

		// Cidade e estado
		System.out.println("Inicio Cidade Estado");
		Cidade cidade = new Cidade();
		Estado estado = new Estado();

		GenericDAO<Estado> daoEstado = new GenericDAO<Estado>();
		

		estado.setNome("Sao Paulo");
		estado.setSigla("SP");

		cidade.setNome("Praia Grande");
		cidade.setEstado(estado);

		List<Cidade> cidades = new ArrayList<Cidade>();
		cidades.add(cidade);

		estado.SetCidades(cidades);

		daoEstado.salvar(estado);
	//	daoCidade.salvar(cidade);
		System.out.println("Fim Cidade e Estado");
		// cliente
		System.out.println("Inicio Cliente");
		Cliente cliente = new Cliente();
		GenericDAO<Cliente> daoCliente  = new GenericDAO<Cliente>();
		
		cliente.setNome("marcelo");
		cliente.setCep("11700-170");
		cliente.setLogradouro("Rua Rui barbosa, 190");
		cliente.setComplemento("ap 92");
		cliente.setCpf_cnpj("09527534801");
		cliente.setNumero("190");
		cliente.setTelefone("11988528927");
		cliente.setTipo_pessoa("fisica");
		cliente.setEmail("emil");
		daoCliente.salvar(cliente);
		// venda

		cliente.setCidade(cidade);
		
		
		daoCliente.Atualizar(cliente);
		System.out.println("fim cliente");
		System.out.println("Inicio Venda");
		Venda venda = new Venda();
		GenericDAO<Venda> daoVenda = new GenericDAO<Venda>();

		Date data = new Date(System.currentTimeMillis());

		venda.setData_criacao(data);
		System.out.println(venda.getData_criacao());
		venda.setStatus("Aberto");
		venda.setValor_total(0.0);
		venda.setCliente(cliente);

		daoVenda.salvar(venda);

		System.out.println("Fim Venda");
		
		// item venda
		System.out.println("Inicio item venda");
		ItemVenda itemVenda1 = new ItemVenda();
		ItemVenda itemVenda2 = new ItemVenda();
		ItemVenda itemVenda3 = new ItemVenda();
		
		GenericDAO<ItemVenda> daoItemVenda = new GenericDAO<ItemVenda>();
		
		Double valorTotal = 0.0;
		itemVenda1.setCerveja(cerveja1);
		itemVenda1.setQuantidade(20);
		itemVenda1.setValor_unitario(25.99);
		
		valorTotal += itemVenda1.getValor_unitario() * itemVenda1.getQuantidade();
		
		itemVenda2.setCerveja(cerveja2);
		itemVenda2.setQuantidade(10);
		itemVenda2.setValor_unitario(35.99);
	
		valorTotal += itemVenda2.getValor_unitario() * itemVenda2.getQuantidade();
		
		itemVenda3.setCerveja(cerveja);
		itemVenda3.setQuantidade(15);
		itemVenda3.setValor_unitario(14.99);
		valorTotal += itemVenda3.getValor_unitario() * itemVenda3.getQuantidade();
		
		
		venda.setValor_total(valorTotal);
		itemVenda1.setVenda(venda);
		itemVenda2.setVenda(venda);
		itemVenda3.setVenda(venda);
		
		daoItemVenda.salvar(itemVenda1);
		daoItemVenda.salvar(itemVenda2);
		daoItemVenda.salvar(itemVenda3);
		daoVenda.Atualizar(venda);
		System.out.println("fim item venda");
		//grupo
		System.out.println("Inicio grupo");
		Grupo grupo = new Grupo();
		GenericDAO<Grupo> daoGrupo = new GenericDAO<Grupo>();
		
		grupo.setNome("grupo1");
		daoGrupo.salvar(grupo);
		System.out.println("fim grupo");
		
		System.out.println("Inicio permissao");
		Permissao permissao = new Permissao();
		GenericDAO<Permissao> daoPermissao = new GenericDAO<Permissao>();
		
		permissao.setNome("Permissao1");
		List<Grupo> grupos = new ArrayList<Grupo>();
		grupos.add(grupo);
		
		
		daoPermissao.salvar(permissao);
		System.out.println("fim permissao");
 		GrupoPermissao grupoPermissao = new GrupoPermissao();
		grupoPermissao.setId(new GrupoPermissaoID(permissao, grupo));
		
		daoPermissao.salvarGrupo(grupoPermissao);
		System.out.println("Salvando Grupo Permissao");
		// -------- 		
	
		System.out.println("Inicio Usuario");
		Usuario usuario = new Usuario();
		GenericDAO<Usuario> daoUsuario = new GenericDAO<Usuario>();
		
	
		 DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		 LocalDate dataNasc = LocalDate.parse("08/03/1972", formato); 
		 
		
		
		usuario.setAtivo(1);
		usuario.setEmail("email");
		usuario.setNome("Marcelo S");
		usuario.setSenha("asd123");
		usuario.setDataNascimento(dataNasc);
		daoUsuario.salvar(usuario);
		System.out.println("Fim Usuario");
		
		UsuarioGrupo usuarioGrupo = new UsuarioGrupo();
		usuarioGrupo.setId(new UsuarioGrupoID(usuario, grupo));
		daoUsuario.salvarUsuarioGrupo(usuarioGrupo);
		
		System.out.println("Fim Usuario Grupo");
		
		System.out.println("Atualizar venda com usuario");
		venda.setUsuario(usuario);
		daoVenda.Atualizar(venda);
		
		System.out.println("Fim atuliza venda com usuario");
		
		
		
		
	}
}
