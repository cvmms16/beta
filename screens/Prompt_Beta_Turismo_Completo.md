# PROMPT COMPLETO --- BETA TURISMO \| GESTÃO DE VIAGENS E PASSAGEIROS

Quero que você organize e melhore o meu aplicativo **Beta Turismo -
Gestão**, desenvolvido em Kotlin, Android Studio, Jetpack Compose e
Material 3.

O aplicativo será utilizado pela administradora de uma empresa de
turismo para cadastrar viagens e excursões, organizar os ônibus,
distribuir os passageiros nos assentos e controlar os pagamentos.

Quero um aplicativo com aparência profissional, organizado, acessível,
bonito e fácil de utilizar. Não quero uma interface exagerada ou com
aparência artificial. O design deve ser simples, elegante e funcional.

**Antes de começar, analise o código existente e entenda como o projeto
está estruturado.** Faça as alterações diretamente nos arquivos
necessários, preservando as funcionalidades que já funcionam e
aproveitando a estrutura atual. Não recrie o projeto do zero.

# 1. IDENTIDADE VISUAL

Quero manter a identidade do Beta Turismo com as cores amarelo, azul e
branco, mas com tons que combinem entre si.

Utilize a seguinte paleta:

-   Amarelo principal: `#FFC928`
-   Azul principal: `#174A7E`
-   Azul secundário: `#4D8FC7`
-   Fundo geral: `#F2F7FC`
-   Branco dos cartões: `#FFFFFF`
-   Texto principal: `#172B3A`
-   Texto secundário: `#657586`
-   Bordas: `#DCE6F0`

O azul será utilizado para títulos, cabeçalhos, navegação e elementos de
destaque. O amarelo será utilizado nos botões principais e nas ações
importantes. O branco será predominante nos cartões e nas áreas de
conteúdo.

Evite excesso de sombras, muitas cores diferentes, gradientes
exagerados, elementos decorativos desnecessários e botões enormes.

Utilize cantos arredondados moderados, ícones simples, boa legibilidade
e espaçamentos consistentes.

Centralize o nome Beta Turismo no cabeçalho da tela inicial. A
tipografia deve ser moderna, bonita e fácil de ler. Caso seja
necessário, utilize um subtítulo discreto como "Gestão de viagens".

Mantenha a mesma identidade visual em todas as telas, inclusive nos
formulários, na planta dos ônibus e na lista de passageiros.

# 2. COMO O APLICATIVO DEVE FUNCIONAR

O aplicativo terá estas áreas principais:

1.  **Página inicial:** lista de viagens cadastradas e botão de
    adicionar.
2.  **Cadastro de viagem:** formulário para adicionar uma nova viagem.
3.  **Cadastro e gerenciamento da frota:** cadastro independente dos
    ônibus da empresa.
4.  **Detalhes da viagem:** tela com dois ícones principais, um de
    ônibus e outro de passageiros.
5.  **Gerenciamento dos ônibus e passageiros:** controle dos assentos,
    cadastro das pessoas e acompanhamento dos pagamentos.

A navegação entre essas telas deve ser simples, com títulos claros e uma
opção para voltar à tela anterior.

Cada viagem cadastrada deverá ter seus próprios ônibus, assentos,
passageiros e pagamentos. Os dados de uma viagem não poderão aparecer
misturados com os de outra.

# 3. PÁGINA INICIAL --- LISTA DE VIAGENS

A tela inicial deverá mostrar todas as viagens cadastradas pela
administradora.

No cabeçalho, centralize o nome Beta Turismo e utilize uma combinação
harmoniosa de azul, amarelo e branco.

Abaixo do cabeçalho, mostre o título "Viagens cadastradas".

Cada viagem deverá aparecer em um cartão branco, com boa organização e
espaçamento.

Cada cartão deverá apresentar somente:

-   Nome da viagem, com origem e destino.
-   Data de ida.
-   Data de volta.
-   Botão "Ver detalhes".
-   Opção discreta para excluir a viagem.

Exemplo de organização:

**Recife → Caruaru**

Ida: 20/12/2026 Volta: 22/12/2026

\[Ver detalhes\] \[Excluir\]

Não mostre preço, quantidade de ônibus, assentos disponíveis ou outras
informações nessa tela. Esses dados ficarão disponíveis dentro dos
detalhes da viagem.

Os cartões deverão ter a mesma largura, alinhamento consistente, cantos
arredondados e sombras leves.

Se houver muitas viagens, a lista deverá permitir rolagem vertical.

No canto inferior direito, mantenha um botão flutuante com o símbolo de
adicionar (+). Ao clicar nele, mostre duas opções: **"Adicionar
viagem"** e **"Adicionar ônibus"**. A primeira abre o formulário de
viagem; a segunda abre o formulário independente de cadastro de ônibus
descrito na seção 15. O menu deve ser compacto, visualmente organizado e
fácil de usar.

Ao excluir uma viagem, solicite confirmação antes de removê-la.

# 4. CADASTRO DE UMA NOVA VIAGEM

Quando a administradora clicar no botão de adicionar (+), deverá abrir
uma tela própria para cadastrar a viagem.

O formulário deverá ser dividido em partes bem organizadas, com campos
identificados e fáceis de preencher.

## Informações da viagem

A administradora deverá preencher:

-   Nome da viagem ou excursão.
-   Cidade de origem.
-   Cidade de destino.
-   Data de ida.
-   Data de volta.
-   Preço da viagem por passageiro.

## Seleção dos ônibus para a viagem

A administradora deverá poder selecionar um ou mais ônibus que já
estejam cadastrados na frota. A tela deverá mostrar a identificação de
cada veículo e sua capacidade, permitindo escolher quais serão
utilizados nessa viagem.

Se ainda não houver ônibus cadastrados, apresente uma opção clara para
cadastrar um ônibus e depois retornar ao cadastro da viagem, sem perder
os dados que já foram preenchidos.

Não exija que a administradora cadastre todos os dados físicos do ônibus
novamente a cada viagem. Reutilize o cadastro da frota e a configuração
dos assentos já existente. A quantidade de assentos e a planta deverão
corresponder à configuração real do veículo.

A disponibilidade do ônibus deverá ser verificada conforme as datas e,
quando houver, os horários da viagem, evitando associar o mesmo veículo
a viagens incompatíveis.

Organize o formulário em seções, evitando colocar todos os campos em uma
única área extensa.

## Botões do formulário

Na parte inferior, disponibilize:

-   "Cancelar", para sair sem salvar as alterações.
-   "Cadastrar viagem", para salvar os dados.

Valide os campos obrigatórios, as datas e o preço.

A data de volta não poderá ser anterior à data de ida. O preço deverá
ser um valor válido.

Depois de cadastrar a viagem com sucesso, a administradora deverá voltar
automaticamente para a página inicial, onde a nova viagem aparecerá na
lista.

A viagem cadastrada deverá permanecer salva ao sair e abrir o aplicativo
novamente.

# 5. TELA DE DETALHES DA VIAGEM

Quando a administradora clicar em "Ver detalhes" em uma viagem, deverá
ser direcionada para uma tela exclusiva daquela viagem.

No topo, apresente o nome da viagem e um resumo discreto com a origem, o
destino e as datas.

Abaixo, quero dois cartões grandes, organizados e fáceis de identificar:

**Ícone de ônibus --- Ônibus e assentos**

Permite visualizar os ônibus cadastrados e organizar os lugares dos
passageiros.

**Ícone de pessoas --- Passageiros e pagamentos**

Permite visualizar a lista de passageiros, cadastrar pessoas, consultar
documentos e acompanhar a situação financeira de cada uma.

Os cartões deverão ter ícones claros, títulos objetivos e uma breve
explicação do que cada opção faz.

Ao tocar em um cartão, a administradora deverá entrar na área
correspondente.

Não misture as duas funcionalidades em uma única tela cheia de
informações. Quero que cada área tenha sua própria organização.

# 6. ÁREA DOS ÔNIBUS E DOS ASSENTOS

Ao clicar no ícone de ônibus, deverá abrir uma tela para selecionar e
gerenciar os ônibus daquela viagem.

Se a viagem possuir mais de um ônibus, mostre uma lista ou seletor com a
identificação de cada um.

Exemplo:

-   Ônibus 1 --- 40 assentos.
-   Ônibus 2 --- 46 assentos.
-   Ônibus 3 --- 32 assentos.

Os números acima são apenas exemplos. A quantidade real deverá vir dos
dados cadastrados pela administradora.

Ao selecionar um ônibus, mostre a planta dos assentos, representando a
organização interna do veículo.

## Planta do ônibus

Quero uma representação visual que lembre a disposição real dos bancos
dentro de um ônibus.

A planta deverá conter:

-   Indicação da parte dianteira do ônibus.
-   Indicação da posição do motorista.
-   Corredor central, quando aplicável.
-   Fileiras de assentos organizadas.
-   Numeração individual de cada assento.
-   Identificação visual dos assentos livres e ocupados.
-   Legenda explicando o significado das cores.

A planta deverá se adaptar à quantidade e à configuração de assentos
cadastradas.

Utilize cores discretas e acessíveis. Por exemplo:

-   Assento livre: fundo branco com borda azul.
-   Assento ocupado: azul, com texto branco.
-   Assento selecionado para uma operação: amarelo, com texto escuro.

Não dependa somente das cores: mostre também a numeração e, quando útil,
o status do assento.

## Cadastro de passageiros nos assentos

A administradora será responsável por colocar cada passageiro em seu
devido lugar.

Ao tocar em um assento livre, abra uma opção para selecionar um
passageiro já cadastrado ou cadastrar um novo passageiro.

O cadastro deverá solicitar:

-   Nome completo.
-   CPF.
-   RG.

Após salvar, o passageiro deverá ficar associado àquele assento e ao
ônibus selecionado.

Ao tocar em um assento ocupado, mostre as informações necessárias para
que a administradora identifique quem está sentado naquele lugar.

Disponibilize opções para:

-   Consultar o passageiro.
-   Alterar o passageiro associado ao assento.
-   Liberar o assento, mediante confirmação.

## Exclusão e liberação de assentos

A administradora também deverá conseguir remover um passageiro de um
assento quando necessário.

Antes de confirmar, mostre uma mensagem explicando a ação.

A liberação do assento não deverá apagar automaticamente o cadastro do
passageiro, pois ele poderá continuar registrado na lista de pessoas da
viagem.

Se a administradora decidir excluir definitivamente o passageiro da
viagem, o sistema deverá tratar essa ação separadamente e solicitar
confirmação.

O assento deverá voltar ao estado de livre depois que sua ocupação for
removida.

**Regra importante:** um passageiro não poderá ocupar dois assentos no
mesmo ônibus ao mesmo tempo, e dois passageiros não poderão ser
associados ao mesmo assento.

# 7. ÁREA DE PASSAGEIROS E PAGAMENTOS

Ao clicar no ícone de pessoas, deverá abrir a lista de passageiros da
viagem selecionada.

Essa tela deverá permitir cadastrar, consultar, editar e excluir
passageiros.

No topo, mostre o título "Passageiros" e uma opção clara para adicionar
uma pessoa.

Se necessário, inclua uma busca por nome ou documento para facilitar a
localização de passageiros em listas grandes.

## Cadastro de passageiros

O formulário deverá conter:

-   Nome completo.
-   CPF.
-   RG.
-   Ônibus associado.
-   Assento associado.
-   Preço da viagem.
-   Forma ou condição de pagamento.

O cadastro poderá ser iniciado pela tela de passageiros ou pela planta
do ônibus.

Se o passageiro for cadastrado pela planta, o ônibus e o assento
selecionados deverão ser preenchidos automaticamente no cadastro.

Se for cadastrado pela lista de passageiros, a administradora poderá
escolher o ônibus e o assento disponíveis.

Os dados obrigatórios deverão ser validados antes de salvar.

O CPF deverá ter seu formato validado e não poderá ser repetido
indevidamente dentro da mesma viagem.

O sistema deverá evitar cadastros duplicados por engano.

## Lista de passageiros

Cada passageiro deverá aparecer em um cartão compacto ou em uma linha
organizada.

Na lista, mostre:

-   Nome completo.
-   Identificação do ônibus e do assento, quando houver.
-   Status do pagamento.
-   Opção para abrir os detalhes.
-   Opção discreta para editar ou excluir.

Não mostre o CPF e o RG completos diretamente na lista geral. Esses
documentos deverão aparecer na tela de detalhes do passageiro, acessível
somente à administradora autorizada.

A lista deverá ser fácil de percorrer, inclusive quando a viagem possuir
muitos passageiros.

# 8. CONTROLE DE PAGAMENTOS

Cada passageiro deverá possuir um controle financeiro individual,
vinculado à viagem.

O sistema deverá trabalhar com três situações de pagamento:

**Pendente:** o passageiro ainda não concluiu o pagamento e existe um
valor em aberto.

**Pago:** o valor total da viagem foi quitado.

**Parcelado:** o passageiro está pagando em parcelas, e ainda existem
parcelas pendentes.

Na tela de detalhes do passageiro, mostre:

-   Preço total da viagem.
-   Valor já pago.
-   Saldo restante.
-   Status atual do pagamento.
-   Quantidade de parcelas, quando aplicável.
-   Valor de cada parcela.
-   Parcelas pagas e pendentes.

Quando o status for "Parcelado", a administradora deverá informar em
quantas vezes o pagamento foi dividido.

O sistema deverá calcular os valores das parcelas e acompanhar os
pagamentos realizados.

Exemplo:

Preço da viagem: R\$ 300,00 Condição: Parcelado em 3 vezes Valor de cada
parcela: R\$ 100,00

Parcela 1 --- Paga Parcela 2 --- Pendente Parcela 3 --- Pendente

Esse exemplo serve apenas para demonstrar o funcionamento.

A administradora deverá poder registrar cada pagamento realizado e
atualizar o status financeiro do passageiro.

Quando o valor total estiver quitado, o status deverá passar para
"Pago". Enquanto houver valores em aberto, o sistema deverá manter a
situação financeira coerente com os pagamentos registrados.

Não marque automaticamente um pagamento como realizado sem uma ação de
confirmação da administradora.

Utilize cores discretas para identificar os estados:

-   Pendente: amarelo suave.
-   Pago: verde suave.
-   Parcelado: azul suave.

As cores deverão manter contraste adequado e não substituir os textos de
status.

# 9. EXCLUSÃO DE PASSAGEIROS

A lista de passageiros deverá oferecer uma opção para excluir pessoas
que desistiram da viagem.

Antes de excluir, mostre uma janela de confirmação com o nome da pessoa
e as consequências da operação.

Ao confirmar a exclusão:

-   Remova o vínculo do passageiro com o assento.
-   Libere o assento correspondente.
-   Atualize a lista de passageiros.
-   Atualize as informações da viagem.
-   Preserve a integridade dos demais cadastros.

Se houver pagamentos registrados, não apague silenciosamente o histórico
financeiro. Defina um tratamento adequado para esses registros,
permitindo que a administradora compreenda o que aconteceu.

A exclusão de uma pessoa da viagem e a exclusão de toda a viagem deverão
ser operações distintas.

Se a viagem possuir passageiros associados, também solicite confirmação
antes de excluí-la e informe que os dados relacionados poderão ser
afetados.

# 10. ORGANIZAÇÃO E FACILIDADE DE USO

Quero que o aplicativo seja fácil de utilizar mesmo para uma pessoa que
não tenha muita experiência com tecnologia.

Por isso:

-   Utilize títulos claros.
-   Evite excesso de informações na mesma tela.
-   Organize os formulários em seções.
-   Utilize campos com identificação visível.
-   Mostre mensagens claras de erro e sucesso.
-   Confirme ações importantes, como exclusões.
-   Mantenha os botões principais em posições previsíveis.
-   Use ícones acompanhados de textos quando necessário.
-   Permita voltar para a tela anterior sem perder dados preenchidos
    indevidamente.
-   Mostre estados vazios bem organizados quando não houver viagens,
    ônibus ou passageiros cadastrados.

Exemplos de mensagens:

"Você ainda não cadastrou nenhuma viagem."

"Este ônibus ainda não possui passageiros."

"Passageiro cadastrado com sucesso."

"Assento liberado com sucesso."

"Tem certeza de que deseja excluir este passageiro?"

Evite mensagens técnicas que a administradora não entenderia.

# 11. ESTRUTURA DOS DADOS E FUNCIONAMENTO

Organize os dados para que cada informação pertença à viagem correta.

A estrutura deverá contemplar, de forma compatível com o projeto
existente:

-   Viagem.
-   Ônibus.
-   Assento.
-   Passageiro.
-   Pagamento.
-   Parcela, quando aplicável.

Uma viagem poderá possuir vários ônibus.

Um ônibus poderá possuir vários assentos.

Cada assento poderá estar livre ou associado a um passageiro.

Uma viagem poderá possuir vários passageiros, cada um com seus próprios
dados e situação financeira.

Os pagamentos deverão estar associados ao passageiro e à viagem
correspondente.

Os dados deverão continuar disponíveis quando o aplicativo for fechado e
aberto novamente.

Se o projeto já tiver Room configurado, utilize-o para persistência
local. Crie ou adapte entidades, DAOs e repositórios somente quando
necessário para implementar essas funcionalidades.

Se ainda não houver persistência implementada, organize a solução de
forma compatível com a arquitetura atual, sem adicionar tecnologias
desnecessárias.

Mantenha os dados separados por viagem e evite que alterações em uma
viagem modifiquem passageiros, ônibus ou pagamentos de outra.

Como o aplicativo manipula CPF, RG e informações financeiras, não
exponha esses dados desnecessariamente na interface ou em registros de
depuração. Restrinja o acesso administrativo conforme os recursos
existentes no projeto.

# 12. REQUISITOS TÉCNICOS

Implemente as alterações utilizando Kotlin, Jetpack Compose, Material 3
e a estrutura de navegação já existente.

Preserve as dependências atuais sempre que possível.

Organize os componentes de interface para facilitar a manutenção e
evitar que todo o aplicativo fique concentrado em um único arquivo
MainActivity.kt.

Se necessário, separe as telas em arquivos próprios, respeitando a
estrutura atual do projeto.

Utilize componentes reutilizáveis para:

-   Cabeçalho.
-   Cartão de viagem.
-   Botões.
-   Campos de formulário.
-   Cartão de passageiro.
-   Identificação de pagamento.
-   Representação de assento.
-   Diálogos de confirmação.

Mantenha os estados da interface sincronizados com os dados. Ao
cadastrar, editar, excluir ou alterar um pagamento, a tela deverá
atualizar corretamente.

Não implemente apenas telas estáticas. Os botões e formulários deverão
executar suas respectivas ações.

Não adicione dados fictícios como se fossem registros reais.

# 13. ORDEM DE IMPLEMENTAÇÃO

Implemente o aplicativo seguindo esta ordem:

1.  Organizar o tema visual e a identidade do Beta Turismo.
2.  Reformular a página inicial e os cartões das viagens.
3.  Implementar o menu do botão + com as opções "Adicionar viagem" e
    "Adicionar ônibus".
4.  Implementar o cadastro independente da frota de ônibus, incluindo
    capacidade e acessibilidade.
5.  Implementar o cadastro de viagens e a seleção de ônibus já
    cadastrados.
6.  Implementar a tela de detalhes com os dois ícones principais.
7.  Implementar a seleção de ônibus e a planta dos assentos.
8.  Implementar o cadastro e o gerenciamento de passageiros.
9.  Implementar a associação entre passageiros, ônibus e assentos.
10. Implementar o controle de pagamentos e parcelas.
11. Implementar as exclusões com confirmação e atualização dos dados.
12. Revisar a navegação, a acessibilidade e a persistência.
13. Compilar o aplicativo e corrigir os erros encontrados.

Se alguma funcionalidade depender de uma estrutura que ainda não existe,
implemente primeiro os componentes necessários sem quebrar o projeto.

# 14. RESULTADO FINAL ESPERADO

Quero um aplicativo de gestão de excursões que funcione da seguinte
maneira:

A administradora abre o Beta Turismo e visualiza as viagens cadastradas.

Ela clica no botão de adicionar, informa o nome da viagem, origem,
destino, datas de ida e volta, preço e quantidade de ônibus. Depois,
configura cada ônibus e sua capacidade de assentos.

Ao concluir o cadastro, volta para a página inicial e encontra a nova
viagem.

Ao clicar em "Ver detalhes", acessa uma tela com dois cartões: "Ônibus e
assentos" e "Passageiros e pagamentos".

Em "Ônibus e assentos", escolhe o ônibus, visualiza sua planta e associa
os passageiros aos lugares disponíveis. Também consegue liberar assentos
quando necessário.

Em "Passageiros e pagamentos", consulta a lista de pessoas, cadastra
nome completo, CPF e RG, verifica o assento de cada uma e acompanha se o
pagamento está pendente, pago ou parcelado.

Quando o pagamento for parcelado, consegue acompanhar a quantidade de
parcelas, os valores e quais foram quitadas.

Se alguém desistir da viagem, a administradora poderá remover essa
pessoa, com confirmação, e o assento ficará disponível novamente.

Tudo deverá ser organizado, intuitivo, visualmente consistente e fácil
de usar.

**Importante: faça as alterações no código real do projeto, não apenas
descreva como deveriam ser feitas. Preserve as funcionalidades
existentes, não invente dados, verifique as dependências e compile o
aplicativo ao finalizar. Ao concluir, informe os arquivos modificados,
as funcionalidades implementadas e o que ainda depender de
implementação.**

# 15. CADASTRO INDEPENDENTE DE ÔNIBUS E GERENCIAMENTO DA FROTA

Além de cadastrar viagens, a administradora deverá poder cadastrar
ônibus separadamente. O cadastro de um ônibus não deve depender da
existência de uma viagem.

## Menu do botão de adicionar (+)

Na página inicial, ao clicar no botão flutuante (+), mostre duas opções:

-   **Adicionar viagem:** abre o formulário de cadastro de uma viagem.
-   **Adicionar ônibus:** abre o formulário de cadastro de um veículo da
    frota.

Use ícones claros, textos objetivos e o mesmo padrão visual do
aplicativo. O menu pode ser compacto, como um menu suspenso ou uma
pequena janela de opções, sem ocupar a tela inteira.

## Formulário de cadastro de ônibus

Crie uma tela própria para cadastrar um ônibus, com campos organizados
por seções.

**Informações do veículo:** - Nome ou identificação do ônibus, por
exemplo, "Ônibus Executivo 01". - Placa, se a empresa utilizar essa
informação. - Modelo ou descrição, se necessário. - Quantidade total de
assentos convencionais. - Quantidade de espaços ou vagas destinados à
acessibilidade.

**Configuração da planta:** - Número de fileiras. - Disposição dos
assentos por fileira. - Posição do corredor. - Identificação dos
assentos acessíveis. - Identificação de espaços próprios para cadeira de
rodas, quando existirem. - Possibilidade de representar configurações
diferentes entre modelos de ônibus.

A planta deverá respeitar os dados cadastrados. Não crie automaticamente
uma quantidade fixa de assentos para todos os veículos.

Não trate um espaço para cadeira de rodas como se fosse necessariamente
um assento convencional. A administradora deverá conseguir configurar a
disposição real do veículo e identificar as posições acessíveis.

Inclua os botões "Cancelar" e "Cadastrar ônibus". Valide os campos
obrigatórios, a capacidade e as informações da placa, quando fornecida.
Depois de cadastrar com sucesso, mostre uma mensagem clara e
disponibilize o veículo na frota.

## Lista e edição da frota

Organize uma área para consultar os ônibus cadastrados. Cada item deverá
mostrar:

-   Nome ou identificação do veículo.
-   Placa, quando cadastrada.
-   Capacidade de assentos.
-   Quantidade de espaços de acessibilidade.

Disponibilize opções para visualizar detalhes, editar o cadastro e
excluir o veículo. A exclusão deverá exigir confirmação. Se o ônibus
estiver associado a viagens ou tiver registros vinculados, não permita
que seja excluído de forma que deixe os dados inconsistentes; explique à
administradora o que precisa ser resolvido.

## Associar ônibus a uma viagem

No formulário de viagem, a administradora deverá selecionar os veículos
já cadastrados que serão utilizados naquela excursão. Uma viagem poderá
ter mais de um ônibus.

A configuração física do veículo deverá ser reutilizada, incluindo a
capacidade, a planta e os espaços de acessibilidade. Não será necessário
recadastrar essas informações em cada viagem.

Se ainda não houver ônibus cadastrados, disponibilize uma forma clara de
iniciar o cadastro de um veículo e retornar ao formulário da viagem sem
perder os campos já preenchidos.

Verifique se o ônibus está disponível para o período da viagem. Se ele
já estiver associado a outra viagem em período incompatível, mostre um
aviso e impeça a associação até que o conflito seja resolvido. Se
horários não forem cadastrados, utilize as datas disponíveis e deixe
claro que a verificação é baseada nos dados informados.

## Separação entre veículo e ocupação

O cadastro do ônibus representa o veículo da frota e sua configuração
física. A ocupação dos assentos e os passageiros pertencem a cada viagem
específica.

Quando o mesmo ônibus for utilizado em outra excursão, a planta física
poderá ser reaproveitada, mas os passageiros, os assentos ocupados e os
pagamentos da viagem anterior não deverão ser copiados.

A administradora deverá conseguir editar os dados do veículo sem alterar
indevidamente os passageiros de viagens já cadastradas. Quando uma
mudança na configuração puder afetar viagens existentes, informe o
impacto antes de confirmar.

## Estrutura técnica

Organize os dados para distinguir:

-   Cadastro geral do ônibus.
-   Associação entre ônibus e viagem.
-   Configuração física dos assentos.
-   Ocupação dos assentos em cada viagem.
-   Passageiros e pagamentos vinculados à viagem.

Se o projeto utilizar Room, implemente ou adapte as entidades, relações,
DAOs e repositórios necessários, respeitando a arquitetura atual.
Preserve os dados existentes e evite duplicações.

## Fluxo esperado

1.  A administradora abre a página inicial.
2.  Clica no botão +.
3.  Escolhe "Adicionar ônibus" para cadastrar um veículo, ou "Adicionar
    viagem" para cadastrar uma excursão.
4.  Ao cadastrar uma viagem, seleciona os ônibus disponíveis da frota.
5.  Ao abrir os detalhes da viagem, acessa "Ônibus e assentos" para
    distribuir os passageiros e "Passageiros e pagamentos" para
    gerenciar os cadastros e valores.

Implemente os botões e formulários de verdade, com persistência dos
dados, validações, mensagens claras e navegação funcionando. Ao
finalizar, compile o aplicativo e informe quais arquivos foram alterados
e quais funcionalidades foram concluídas.
