# 💱 Conversor de Moneda - Android (MVVM)

## 📌 Descripción de la app
Aplicación móvil desarrollada en Android que permite convertir valores entre **Dólares (USD)** y **Euros (EUR)**.

El usuario puede ingresar un valor, seleccionar el tipo de conversión mediante opciones y visualizar el resultado en pantalla. Además, la aplicación permite modificar el tipo de cambio utilizado.

---

## 👥 Autor

- Benenatti Agustin


---

## 🧠 Implementación de MVVM

La aplicación fue desarrollada utilizando el patrón de arquitectura **MVVM (Model - View - ViewModel)**, cumpliendo con la separación de responsabilidades solicitada.

---

### 🔹 Model
El modelo se encarga de la lógica de negocio.

- Contiene los métodos de conversión entre USD y EUR.
- Administra el valor del tipo de cambio.
- Realiza los cálculos matemáticos necesarios.

---

### 🔹 ViewModel
El ViewModel actúa como intermediario entre la vista y el modelo.

- Contiene datos observables mediante **LiveData**, como:
  - Valor ingresado
  - Resultado de la conversión
  - Tipo de cambio
- Procesa la lógica de conversión llamando al Model.
- Notifica automáticamente a la vista cuando los datos cambian.

---

### 🔹 View (Activity)
La vista corresponde a la interfaz gráfica de la aplicación.

- Contiene los componentes:
  - `EditText` para ingreso de datos
  - `RadioButtons` para seleccionar tipo de conversión
  - `Button` para ejecutar la conversión
  - `TextView` para mostrar resultados
- Observa los datos del ViewModel mediante LiveData.


---

## ⚙️ Funcionalidades

- Ingreso de valores numéricos
- Conversión entre:
  - USD → EUR
  - EUR → USD
- Visualización del resultado
- Visualización del tipo de cambio actual
- Modificación del tipo de cambio
- Validación de datos ingresados
- Manejo de errores (campos vacíos o inválidos)

