package com.jakarta.dao.person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;

import com.jakarta.dao.common.GenericDAOInterface;
import com.jakarta.dao.common.ConvertDAODTO;
import com.jakarta.dao.common.GenericDAO;
import com.jakarta.dto.common.GenericDTO;
import com.jakarta.dto.person.PersonDTO;
import com.jakarta.models.LogEntity;
import com.jakarta.models.Person;

@Stateless
//EJB para controlar a transação automaticamente
//@Stateless para não salvar o objeto após a chamada, é o normalmente utilizado
//@Stateful para manter o objeto na sessão, utilizado para carrinho de compras por exemplo
//@Startup @Singleton para executar somente uma vez na inicialização do sistema
//https://www.devmedia.com.br/ejb-introducao-ao-novo-enterprise-javabeans-3-2/30807
@LocalBean
//it's a way to permit to use implements class
public class PersonDAO extends GenericDAO implements Serializable, GenericDAOInterface<PersonDTO, Person>{

	private static final long serialVersionUID = -6321526905232236895L;
	
	public void save(PersonDTO personDTO) throws PersonDAOException{
		Person person = convertFromDTO(personDTO);
		
		if(person.getIdPerson() == null) {
			persist(person);
		}else {
			merge(person);
		}
	}
	
	public List<PersonDTO> listAll() {
		List<Person> listPerson = listAll(Person.class);
		List<PersonDTO> listPersonDTO = new ArrayList<PersonDTO>();
		for (Person person : listPerson) {
			listPersonDTO.add(convertFromEntity(person));
		}
		
//		Class<List<PersonDTO>> clazz = (Class) List.class;
		
//		Client client = ClientBuilder.newBuilder().build();
//        WebTarget target = client.target("http://localhost:8081/person/listAll");
//        Response response = target.request().get();
        //String value = response.readEntity(String.class); //new Gson().toJson(this) Carrinho carrinho = (Carrinho) new XStream().fromXML(conteudo);
//        String value = response.readEntity(String.class); //new Gson().toJson(this) Carrinho carrinho = (Carrinho) new XStream().fromXML(conteudo);
//        List<PersonDTO> listPersonDTO = new Gson().fromJson(value, clazz);//, new TypeToken<List<PersonDTO>>(){}.getType()); //new TypeToken<Collection<Foo>>(){}.getType();
//        response.close();  // You should close connections!
		
////		for (Person person : listPerson) {
//			listPersonDTO.add(convertFromEntity(person));
//		}
		
		return listPersonDTO;
	}

	@Override
	public Person convertFromDTO(PersonDTO dto) {
		Person person = new Person();
		person.setIdPerson(dto.getIdPerson());
		person.setCpf(dto.getCpf());
		person.setBirthDate(dto.getDateBirth());
		person.setEmail(dto.getEmail());
		person.setName(dto.getName());
		person.setPhone(dto.getPhone());
		person.setLogEntity(ConvertDAODTO.convertLogDTOToLogEntity(dto.getLogDTO()));
		
		return person;
	}

	@Override
	public PersonDTO convertFromEntity(Person entity) {
		PersonDTO personDTO = new PersonDTO(
				entity.getIdPerson(), entity.getCpf(), entity.getBirthDate(), entity.getEmail(),
				entity.getName(), entity.getPhone()
		);
		personDTO.setLogDTO(ConvertDAODTO.convertLogEntityToLogDTO(entity.getLogEntity()));
		
		return personDTO;
	}

}
