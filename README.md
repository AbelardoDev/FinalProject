# Simulador de Atención de Soporte – TechClassUC

## Proyecto Final — Programación II

**Autores:**  
- Abelardo Ochoa  
- Luisa Mercado  

**Curso:** Programación II – Ingeniería de Sistemas  
**Semestre:** 2025-2  
**Docente:** Alberto Paternina  
**Lugar / Fecha:** Montería – Córdoba, 2025

---

## Descripción

Este proyecto implementa un **Simulador de Atención al Cliente** mediante una interfaz gráfica en Java (Swing). Permite gestionar el flujo de atención de clientes: llegada, espera, atención, eliminación, historial, estadísticas, búsqueda y simulación automática — ideal para gestión de soporte técnico.

El sistema representa un escenario realista de atención al cliente, usando estructuras de datos como cola, lista y pila, lo que facilita el manejo dinámico de solicitudes y un registro completo de acciones para auditoría o deshacer operaciones.

---

## Arquitectura y Diseño

- Basado en **Programación Orientada a Objetos (POO)**  
- Estructura de capas:
  - **Modelo:** estructuras de datos (cola de espera, lista de atendidos, registro de acciones)  
  - **Controlador (Controller):** lógica de negocio y mediación entre modelo y vista  
  - **Vista (GUI Swing):** interfaz de usuario  

### Estructuras de datos principales

| Estructura | Propósito |
|------------|-----------|
| `ArrayDeque<Client>` | Cola de espera — recibe nuevos clientes (FIFO) |
| `List<Client>` (LinkedList / ArrayList) | Historial de clientes atendidos |
| `Stack<Action>` | Registro de acciones (ADD, REMOVE, ATTEND, UNDO) para auditoría y reversión |

### Flujo principal del sistema

1. Llegada → el cliente se añade al final de la cola.  
2. Atención → se extrae el primer cliente, se atiende y luego se mueve a la lista de atendidos, registrando tiempos.  
3. Eliminación → permite remover clientes en espera, con posibilidad de deshacer.  
4. Historial & Estadísticas → registro de acciones, lista de atendidos, tiempo promedio, totales.  
5. Función **UNDO** → permite revertir las últimas operaciones según tipo (ADD, REMOVE, ATTEND).  

---

## Funcionalidades

- Agregar cliente nuevo (ID, nombre, categoría, prioridad)  
- Atender cliente (extraer de la cola)  
- Finalizar atención (registrar tiempo, mover a lista de atendidos)  
- Eliminar cliente en espera  
- Buscar cliente por **ID** o **categoría** (Soporte / Mantenimiento / Reclamo)  
- Ver historial completo de acciones  
- Deshacer (UNDO) — revertir última acción relevante  
- Ver estadísticas: número en espera, atendidos, tiempo promedio  
- Simulación automática de un “día completo” — agrega/atiende/elimina clientes automáticamente  

---

## Cómo ejecutar / usar el proyecto

1. Clona el repositorio:
   ```bash
   git clone https://github.com/AbelardoDev/FinalProject.git
