// constantes para almacenar la referencia de los botones
const btnAddAhorro = document.getElementById('addAhorro');
const btnAddGasto = document.getElementById('addGasto');
const btnAddPrestamo = document.getElementById('addPrestamo');

// constantes para almacenar la referencia para el cierre del popup
const btnCerrarPopupAhorro = document.getElementById('btn-cerrar-popup-ahorro');
const btnCerrarPopupGasto = document.getElementById('btn-cerrar-popup-gasto');
const btnCerrarPopupPrestamo = document.getElementById('btn-cerrar-popup-prestamo');

// constantes para almacenar la referencia de los contenedores a mostrar mediante overlay y popup

// ahorro
const overlayAhorro = document.getElementById('overlay-ahorro');
const popupAhorro = document.getElementById('popup-ahorro');
// gastos
const overlayGasto = document.getElementById('overlay-gasto');
const popupGasto = document.getElementById('popup-gasto');
// prestamos
const overlayPrestamo = document.getElementById('overlay-prestamo');
const popupPrestamo = document.getElementById('popup-prestamo');

// eventos para ahorro
btnAddAhorro.addEventListener('click', () => {
	_addClassActive(overlayAhorro, popupAhorro);
});

btnCerrarPopupAhorro.addEventListener('click', () => {
	_removeClassActive(overlayAhorro, popupAhorro);
});

// eventos para gastos
btnAddGasto.addEventListener('click', () => {
	_addClassActive(overlayGasto, popupGasto);
});

btnCerrarPopupGasto.addEventListener('click', () => {
	_removeClassActive(overlayGasto, popupGasto);
});

// eventos para prestamos

btnAddPrestamo.addEventListener('click', () => {
	_addClassActive(overlayPrestamo, popupPrestamo);
});

btnCerrarPopupPrestamo.addEventListener('click', () => {
	_removeClassActive(overlayPrestamo, popupPrestamo);
});

const _addClassActive = (overlay, popup) => {
	overlay.classList.add('active');
	popup.classList.add('active');
};

const _removeClassActive = (overlay, popup) => {
	overlay.classList.remove('active');
	popup.classList.remove('active');
};
