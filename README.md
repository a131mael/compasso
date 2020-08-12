Observações:

1 - Foi utilizado um banco postgres
Então para rodar o exemplo é nescessário ter um banco de dados local definido no arquivo

"application.properties" 

ou alterar as configurações do arquivo para utilizar outro banco


2 - Foi utilizado ENUNs para o cadastro de cliente e cidade, para evitar hardcode ou criar mais um cadastro, desta forma para salvar um novo cliente o campo sexo deve ser um enum
	
	MASCULINO("Masculino"),  
	FEMININO("Feminino"),
	NAO_INFORMADO("Não Informado");

0 para masculino
1 para feminino 
2 para nao informado

ficando o body como algo semelhante a:
{
"nome": "Joao da Silva",
"sexo": 0,
"nascimento": "05/11/1987"
} 

3 o Cadastro de Cidades tambem possui um ENUM de estado, devendo ser colocado o numero do enum no estado
exemplo de body para cidade
{
"nome": "Cidade 1",
"estado": 1
}

3 - Para as buscas por nome tanto de cidade quanto de usuário foi utilizado o startsWith, ou seja o nome buscado deve iniciar com o nome desejado,
por exemplo 
localhost:8080/clientes/?name=J