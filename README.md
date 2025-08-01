# Live sobre JWT

Em 18/06/2025 ocorreu a live sobre JWT. Nesta foram apresentados conceitos sobre segurança de aplicações web, protocolos de autenticação e JWT.

Link youtube: https://www.youtube.com/watch?v=BHsJq2vDnIc

# Apresentação

O PDF da apresentação está em /docs/JWT.pdf

# Aplicação

A aplicação foi feita com SpringBoot 3.5.0, utilizando apenas o stater-web. Além disto, usa-se o Lombok e as dependencias para jwt. A versão do Java é 21. Não foi configurado o Swagger. O Postman deve ser utilizado para testes.

# Funcionamento

Primeiro deve-se solicitar a criação do token pela url <http://localhost:8080/auth> via _HTTP Post_. No *body* devem ser passados 2 parâmetros: *cliente* com valor **XPTO** e *senha* com valor **%RDiwL@^i|{W**. Estes devem ser informados via _x-www-form-urlencoded_. Desta forma o token deve ser criado e retornado. Após isso, o mesmo deve ser configurado no Authorization, para assim ser enviado no header da requisição para a url <http://localhost:8080/fazerAlgo> via _HTTP GET_. Desta forma, uma mensagem de que o recurso foi acessado deve ser exibida. A imagem a seguir ilustra este mecanismo.

![{w=100%}](docs/jwt.png)

Caso o token expire, seja inválido ou não tenha sido fornecido, uma mensagem informativa é exibida.

# Links úteis

https://dinochiesa.github.io/jwt/

https://iotools.cloud/pt/tool/rsa-key-generator/

https://datatracker.ietf.org/doc/html/rfc7519

https://avera.com.br/blog/jwt-como-usar-algoritmos
