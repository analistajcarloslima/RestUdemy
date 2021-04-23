package br.com.jow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.jow.model.Person;
import br.com.jow.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
// para realizar a injeção que será equivalente a instanciar a classe usa a notação
@Autowired
private PersonServices services;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable("id") String id){
		return services.findById(id);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll(){
		return services.findAll();
	}


	//criar um método que faz a inseção de um objeto person
	// para tal adiciono a notação que o metodo vai consumir e produzir Json
	// chamo o método create  que esa em person services
	@RequestMapping(method = RequestMethod.POST,consumes =MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	public Person create(@RequestBody Person person){
		return services.create(person);
	}

	//criar um método que realiza o update
	//para isso usamos o PUT
	@RequestMapping(method = RequestMethod.PUT,consumes =MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	public Person update(@RequestBody Person person){
		return services.update(person);
	}	

//criar um método que realiza o delete
	//para isso usamos o DELETE
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") String id){
		services.delete(id);
	}

}

/*
 * // request mapping define que é uma função que será disponibilizada no //
 * webservice // os parametros a serem recebidos são definidos nas entre chaves
 * 
 * @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method =
 * RequestMethod.GET)
 * 
 * // a notação @RequestParam permite que os valores passados sejam opcionais //
 * Default value adiciona um valor padrão caso não seja pasasado uma parametro
 * 
 * // no caso da caulculadora vamos usar o PathVariable para indicar que são //
 * obrigatórios os envios dos parametros public Double
 * sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo")
 * String numberTwo) throws Exception {
 * 
 * // criar um método de verificação para saver se os valores passados são
 * numerios
 * 
 * // neste caso estou usando a negação
 * "!"" e a estrutura de comparação '||' "ou" // para fazer essa verificação if
 * (!isNumeric(numberOne) || !isNumeric(numberTwo)) { throw new
 * UnsuportedMathOperation("Insira um número válido"); }
 * 
 * // criar o método de conversão de string para double Double sum =
 * convertToDouble(numberOne) + convertToDouble(numberTwo); return sum; }
 */
