🎯 Canvas do Projeto Final — Aplicativo Android
Informações do projeto
Grupo: Alexsandro Soares, Ana Beatrys, Cauanne Victória, Laryssa Domingos, Júlia Allana
Turma: 3º ano A — Ensino Médio
Repositório: cvmms16/beta
Data: 16/09/2026
Entrega: 10/12/2026
🧩 Bloco 1 — Nome e pitch

Nome do app: Beta

Pitch: O Beta ajuda a administradora da Beta Turismo a organizar viagens, passageiros, pagamentos e reservas de assentos em um único sistema.

😖 Bloco 2 — Problema

Problema: A organização manual dificulta visualizar passageiros confirmados, pagamentos, cancelamentos e assentos disponíveis em cada viagem.

Como é feito hoje: As reservas são controladas manualmente, dificultando a organização e o acompanhamento das viagens.

👥 Bloco 3 — Público-alvo
Perfil principal: Administradora da Beta Turismo.
Uso: Cadastro, organização e acompanhamento de viagens, passageiros e reservas.
💡 Bloco 4 — Solução em uma tela

A tela principal apresenta as viagens cadastradas, permitindo consultar seus detalhes e realizar reservas.

Lista: Viagens disponíveis, com destino e dados.
Ação principal: Escolher uma viagem e selecionar um assento disponível.
Resultado: Confirmação da reserva e assento escolhido.
✅ Bloco 5 — Funcionalidades do MVP
#	Funcionalidade	Essencial?	Quem faz
F1	Cadastrar e visualizar viagens	Sim	Administradora
F2	Visualizar ônibus e assentos disponíveis	Sim	Administradora
F3	Realizar, cancelar e consultar reservas	Sim	Administradora
F4	Controlar pagamentos dos passageiros	Sim	Administradora
🚫 Bloco 6 — Fora do escopo
❌ Pagamento online no aplicativo.
❌ Chat entre passageiros.
❌ Notificações push e integração com WhatsApp.
❌ Sincronização em nuvem ou sistema para múltiplas empresas.
⚙️ Bloco 7 — Caminho técnico

Tecnologias: Kotlin, Jetpack Compose, Room, Android Jetpack e Git/GitHub.

Try/catch: Será usado em operações de armazenamento e recuperação de dados para evitar que erros fechem o aplicativo.

Pode falhar: Salvamento, alteração ou exclusão de viagens e reservas.

Mensagem: Não foi possível realizar esta ação. Tente novamente.

Validação: Impedir reservas em assentos já ocupados.

🎨 Bloco 8 — Identidade visual
Item	Definição
Nome	Beta
Cor principal	#ffc222
Ícone	“Vai de Beta Turismo”, com azul, amarelo e elementos relacionados a viagens
ID	br.edu.ifpe.beta
Versão	1.0 (versionCode 1)
👤 Bloco 9 — Equipe, papéis e riscos
Integrante	Papel principal	Responsável por
Alexsandro e Laryssa	Dev / telas	Interfaces e navegação
Júlia	Dev / dados	Banco e operações de dados
Cauanne	Design	Identidade visual
Ana	Documentação	README, testes e builds

Riscos:

Planta dos ônibus complexa → simplificar mantendo seleção e status dos assentos.
Muitas funcionalidades → priorizar as quatro do MVP.
🤖 Bloco 10 — Acordo de trabalho com IA

A implementação pode utilizar o Gemini no Android Studio. Todo código gerado deve ser compreendido, revisado e testado pela equipe.

Regras:

A IA deve seguir o escopo definido.
Todo código gerado ou alterado deve ser revisado e testado.
A IA deve seguir a arquitetura e tecnologias do projeto.

Combinados: Não aceitar alterações sem revisão, não inserir senhas ou chaves de API e revisar o projeto antes dos marcos.

Conhecimento: Quem implementar uma funcionalidade deverá explicar seu funcionamento aos demais.

🗓️ Bloco 11 — Marcos
Marco	Prazo	Comprovação no GitHub
M1 — Canvas + repositório	16/09	CANVAS.md
M2 — PRD + telas	30/09	PRD.md + imagens
M3 — Funcionalidade base	21/10	Tela + ação + try/catch
M4 — Dados + erros tratados	11/11	Commits da camada de dados
M5 — Identidade visual + APK	25/11	APK testado
M6 — AAB + material de loja + README	02/12	Materiais + README
Entrega e apresentação	10/12	v1.0
🏁 Bloco 12 — Definição de pronto

O aplicativo estará pronto quando:

Abrir e funcionar sem fechar sozinho.
Exibir dados reais.
A ação principal funcionar.
Erros apresentarem mensagens claras.
Possuir nome, ícone e identidade visual próprios.
Duas pessoas externas conseguirem utilizá-lo.
README.md, USO_DE_IA.md e AGENTS.md estiverem preenchidos.
Todos os integrantes conseguirem realizar pequenas alterações.
Os arquivos possuírem os comentários de fronteira definidos pela equipe.
✍️ Validação do professor

Dados: ____________________

Situação: Aprovado / Aprovado com / Refazer

Observações: ____________________

Essa é a versão que eu usaria: não muda a essência do projeto original, apenas deixa o Canvas menor e tira a parte de “cliente/Betânia/empresa que apresentou o problema”, já que o sistema é para a administradora da própria Beta Turismo.
