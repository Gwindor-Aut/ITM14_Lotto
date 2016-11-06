function debit(value) {
	if(value.value <= 0){
		alert("Bitte tragen Sie eine gültige Summe in das Feld ein.");
	} else {
	confirm("Sie sind dabei, " + value.value + "€ von ihrem Lottokonto zu beheben.");
	//ToDo: Logik, DB, ...
	//		Überprüfen, ob so viel Geld auf dem Lottokonto ist
	}
}

function recharge(value){
	if(value.value <= 0){
		alert("Bitte tragen Sie eine gültige Summe in das Feld ein.");
	} else {
		confirm("Sie sind dabei, " + value.value + "€ auf ihr Lottokonto zu buchen.");
		//ToDo: Logik, DB, ...
	}
}