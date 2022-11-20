---------------------------------------------------------------------------------------------------------------------------------------------
Nombre: "Inicio de Proyecto"

Descripción: Se crearon las entidades Gestor y ProductoBase con sus repositorios y controladores complementarios correspondientes. Falta agregar la relación entre las entidades.
---------------------------------------------------------------------------------------------------------------------------------------------
Nombre: "Se relacionó Gestor con ProductoBase"

Descripción: Se agregó la relación 1:M entre Gestor y ProductoBase. En GestorControllerComplement se añadió el método crearProductoBase. Para ello, se generó DTOProductoBase, del cual se obtienen los datos ingresados por el usuario para crear el producto base, y el id del gestor se obtiene de la uri.
---------------------------------------------------------------------------------------------------------------------------------------------
Nombre: "Se añadió la entidad PosiblePersonalización, con su repositorio, y se la relacionó con ProductoBase"
Descripción: Se creó la entidad PosiblePersonalización y RepoPosiblePersonalización. Establecida una relación 1:M entre ProductoBase y PosiblePersonalización. Añadido el método crearPosiblePersonalización en ProductoBaseControllerComplement. Agregado el DTOPosiblePersonalización para obtener los datos a agregar por el usuario para crear la posible personalización, y el id del producto base se obtiene de la uri.