# **Manual de Usuario: Simulador de Atención de Soporte TechClassUC**

Abelardo Ochoa  
 Luisa Mercado



Curso: Programación II 

Ingeniería de Sistemas  
 Semestre: 2025-2  
 Docente: Alberto Paternina

Montería – Córdoba  
 2025

**1\. Introducción**

El sistema de simulación desarrollado por TechClassUC permite gestionar la atención al cliente mediante una interfaz gráfica (JFrame). El programa organiza y registra el flujo completo de interacción con los clientes: llegada, atención, eliminación, historial y estadísticas de uso.

Está diseñado para soportar un mayor volumen de solicitudes y facilitar la organización interna del equipo técnico.

**2\. Inicio del Sistema**

Al ejecutar el programa (Main → Controller.initialize()), se abrirá la ventana principal “Simulador de Atención al Cliente”.

Desde esta ventana se controla todo el sistema:

• Agregar clientes

• Atender clientes

• Finalizar atención

• Eliminar clientes en espera

• Buscar clientes por categoría o ID

• Ver historial

• Deshacer acción

• Simulación automática de un día de trabajo.

**3\. Componentes de la Ventana Principal**

**3.1.** Cola de Clientes en Espera

Muestra una tabla con ID, nombre, tipo de solicitud y prioridad (FIFO).

**3.2.** Lista de Clientes Atendidos

Registra cronológicamente los clientes ya atendidos.

**3.3.** Estadísticas

Incluye:

• Total de clientes en espera

• Total de atendidos

• Tiempo promedio de atención

**3.4.** Botones Principales

• Agregar Cliente – Abre formulario de registro

• Atender Cliente – Toma el primero de la cola

• Finalizar Atención – Termina el proceso y pasa a lista

• Eliminar Cliente – Elimina clientes de la cola

• Buscar Cliente – Por categoría o ID

• Deshacer – Revierte la última acción

• Historial – Ver todas las acciones del día

• Simulación – Ejecuta un flujo completo de prueba automáticamente.

**4\. Registro de un Nuevo Cliente**

1\. Presione “Agregar Cliente”.

2\. Llene el formulario (ID, nombre, categoría, prioridad).

3\. Pulse “Agregar Cliente”.

**5\. Proceso de Atención**

• “Atender Cliente”: extrae el primer cliente de la cola.

• “Finalizar Atención”: registra el tiempo y mueve a la lista.

**6\. Eliminar Cliente**

Seleccione una fila de la tabla y presione “Eliminar Cliente”.

**7\. Búsqueda de Clientes**

• Por ID (toggle activado)

• Por categoría (Soporte, Mantenimiento, Reclamo)

**8\. Historial de Acciones**

Muestra todas las operaciones realizadas, incluyendo acciones pendientes de deshacer.

**9\. Función Deshacer (Undo)**

El sistema  tiene una función UNDO totalmente operativo.

Permite revertir:

- ADD  
- REMOVE  
- ATTEND

Cada tipo de acción restaura completamente el estado previo.

**10\. Simulación Automática**

El botón Simulación activa un proceso automático que:

* Agrega clientes.  
* Atiende y finaliza.  
* Elimina.  
* Usa undo.  
* Realiza búsquedas.  
* Muestra historial.

Es ideal para demostraciones o pruebas.

