# Projeto de Programação Orientada a Objeto
## Sistema de Lanchonete

O presente projeto busca simular um pequeno sistema de uma lanchonete onde o quadro de funcionários consiste em:
- Balconistas
- Cozinheiros 
- Gerentes

O menu principal dá as opções de cadastros dos funcionários e também de clientes, insumos e pedidos.

O sistema, além de desempenhar cadastros com as funções CRUD, também realiza tarefas de
- Gerar Pedido: balconista cria um pedido para o cliente, envia para um cozinheiro que, quando o pedido estiver pronto, dá baixa no sistema para que o cliente saiba que o pedido está pronto.
- Abrir Solicitação: cria uma solicitação que é enviada para um gerente. O gerente tem o encargo de, quando resolver a solicitação, dar baixa no sistema.

### Menus de Cadastro
- **_Cadastro de Balconista_**
    - Realiza as operações de inserir, remover, procurar e atualizar balconista.
- **_Cadastro de Cozinheiro_**
    - Realiza as operações de inserir, remover, procurar e atualizar cozinheiro.
- **_Cadastro de Gerente_**
    - Realiza as operações de inserir, remover, procurar e atualizar gerente.
- **_Cadastro de Cliente_**
    - Realiza as operações de inserir, remover, procurar e atualizar cliente.
- **_Cadastro de Pedido_**
    - Realiza as operações de procurar e remover pedido. Este menu serve como um histórico dos pedidos que vão sendo feitos, por isso, não há a opção de inserir pedido diretamente deste menu. Os pedidos são inseridos a medida que o balconista cria um pedido para o cliente. Serve para consulta dos pedidos que já foram feitos.
- **_Cadastro de Insumo_**
    - Realiza as operações de inserir, remover, procurar e atualizar insumo. Este menu também é útil para se ter o controle do que existe no estoque da loja, pois, quando o balconista cria um pedido para o cliente, os insumos utilizados no lanche são retirados do estoque. Os pedidos só são concluídos se houver estoque de insumo suficiente para que o lanche seja feito.
    - Existe uma opção "Encher estoque". Nesta opção, tudo que há de registro de insumo é removido e ele é renovado com 100 unidades de cada insumo para hamburgueres: 
        - 100 unidades de tomate.
        - 100 porções de alface.
        - 100 porções de quejo.
        - 100 unidades de pão.
        - 100 porções de bacon.
        - 100 unidades de carne.

    Esta opção é bastante útil para renovar o estoque de uma só vez.
    - A opção "remover insumo" pede o nome do insumo a ser removido e uma quantidade. Se a quantidade a ser removida for igual a quantidade que há no estoque, o registro do insumo permanece no cadastro e o campo 'quantidade' do insumo será zero. No entanto, se a quantidade a ser removida for maior do que a quantidade existente de insumo, o registro do insumo é retirado do cadastro. Dessa forma, não haverá mais o respectivo objeto insumo na lista de insumos cadastrados.

### Menus dos funcionários
- **_Menu Balconista_**
    - Possui opções de criar pedido para o cliente e enviar solicitação para um gerente.
    - O sistema busca pelo primeiro cozinheiro que está livre para receber o pedido. Para que o pedido possa ser criado, é necessário que haja insumo suficiente para suprir a quantidade de ingredientes que o cliente deseja. Além disso, é necessário haver cozinheiro cadastrado e que não tenha nehum pedido ainda para ser feito. Ou seja, ou o cozinheiro não possui nenhum pedido ou, caso haja pedido com o cozinheiro, ele já tenha dado baixa no sistema para dizer que está pronto. Se a condição de insumo ou a condição do cozinheiro não for atendida, o pedido não é concluído.
    - A medida que os pedidos vão sendo feitos eles vão sendo inseridos no repositório de pedidos, passando a estar disponível para consulta ou remoção.
    - O sistema busca pelo primeiro gerente que está livre para receber a solicitação. Para que possa ser enviado uma solicitação para um gerente, é necessário que exista gerente cadastrado e que ele não tenha solicitação no momento ou, se tiver, que ela já esteja concluída. Caso o gerente tenha solicitação que ainda está em aberto, a solicitação não pode ser enviada para ele.
- **_Menu Cozinheiro_**
    - Possui opções de ver o pedido atual e dar baixa no pedido. 
    - Ao ver o pedido atual (caso haja algum), o cozinheiro recebe todas as informações do pedido, com os ingredientes, entre outros, e o status do pedido (se está concluído ou não).
    - Ao dar baixa no pedido, o status do pedido é alterado para concluído e o cozinheiro passa a ser elegível para receber outros pedidos.
- **_Menu Gerente_**
    - Possui opções de ver solicitação atual e dar baixa na solicitação.
    - Ao ver a solicitação (caso haja alguma), o gerente recebe a mensagem enviada pelo balconista que contém a descrição da solicitação. Além disso, também é mostrado o status da solicitação (se está resolvida ou não).
    - Ao dar baixa na solicitação, o status da solicitação é alterado para resolvido e o gerente passa a ser elegível para receber outras solicitações.
