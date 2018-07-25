SKY Teste
=========

1. Desafio
2. Arquitetura
3. Recursos
4. Instalação
5. Licença

Desafio
=======

Utilizar JSON para fazer parse do nosso conteúdo.
Seu desafio é muito simples: Você deve realizar parse desta url (https://sky-
exercise.herokuapp.com/api/Movies) para construir a tela a seguir.

Arquitetura
===========

Para ter uma arquitetura mais limpa, foi utilizado package by feature.

- MVP - Model View Presenter
- SOLID
- DRY
- IoC

Recursos
========

- ConstraintLayout
- Picasso para carregar as imagens
- Timber para logs
- ButterKnife para injeção de views
- Dagger2, para injeção de dependências;
- Retrofit, para requisições HTTP
- Junit e Mockito, para testes unitários;

Instalação
==========

Para rodar esse projeto utilize uma das seguintes formas:

- Instale o APK disponível na seção de release
- Clone o repositório na sua máquina. Faça o build da aplicação utilizando Android Studio ou via terminal com ./gradlew assembleDebug

Licença
=======

Copyright 2018 Pierry Borges

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

