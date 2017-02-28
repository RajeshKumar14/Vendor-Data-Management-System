
/*
 * Location Module Client side validation
 */

function resetLocForm(){
	document.getElementById("locNameErr").innerHTML = '';
	document.getElementById("locTypeErr").innerHTML = '';
}
function doValidateLocForm() {
	var locName = /^[a-zA-Z]*\,[a-zA-Z]*\,[a-zA-Z]*$/;
	resetLocForm();
	
	if (!(document.locForm.locName.value.match(locName))) {
		document.getElementById("locNameErr").innerHTML = '* Invalid Name Entered';
		return false;
	}
	if (document.locForm.locType[0].checked == false
			&& document.locForm.locType[1].checked == false) {
		document.getElementById("locTypeErr").innerHTML = '* Select any one option';
		return false;
	}
	
	return true;
}

/*
 * Vendor Module Client side validation
 */
function resetVenForm(){
	document.getElementById("venNameErr").innerHTML = '';
	document.getElementById("venLocationErr").innerHTML = '';
	document.getElementById("venEmailErr").innerHTML = '';
	document.getElementById("venMobileErr").innerHTML = '';
}

function doValidateVenForm() {
	var venName = /^[a-zA-Z]{2,15}$/;
	var venEmail=/^[a-zA-Z]+[.]?[a-zA-Z]+[0-9]*\@[a-z]{4,10}\.[a-z]{2,3}$/;
	var venMobile=/^\+[0-9]{12}$/;
	resetVenForm();
	
	if (!(document.venForm.venName.value.match(venName))) {
		document.getElementById("venNameErr").innerHTML = '* Invalid Name Entered';
		return false;
	}
	if (!(document.venForm.venEmail.value.match(venEmail))) {
		document.getElementById("venEmailErr").innerHTML = '* Invalid Email Entered';
		return false;
	}
	if (!(document.venForm.venMobile.value.match(venMobile))) {
		document.getElementById("venMobileErr").innerHTML = '* Invalid Mobile Entered';
		return false;
	}
	
	return true;
}
/*
 * Customer Module Client side validation
 */
function resetCustForm(){
	document.getElementById("custNameErr").innerHTML = '';
	document.getElementById("custLocationErr").innerHTML = '';
	document.getElementById("custEmailErr").innerHTML = '';
	document.getElementById("custMobileErr").innerHTML = '';
}

function doValidateCustForm() {
	var custName = /^[a-zA-Z]{2,15}$/;
	var custEmail=/^[a-zA-Z]+[.]?[a-zA-Z]+[0-9]*\@[a-z]{4,10}\.[a-z]{2,3}$/;
	var custMobile=/^\+[0-9]{12}$/;
	var custRegNum=/^[0-9]{2,5}$/;
	var custAddress=/^[a-zA-Z]+ $/;
	resetCustForm();
	
	if (!(document.custForm.custName.value.match(custName))) {
		document.getElementById("custNameErr").innerHTML = '* Invalid Name Entered';
		return false;
	}
	if (!(document.custForm.custEmail.value.match(custEmail))) {
		document.getElementById("custEmailErr").innerHTML = '* Invalid Email Entered';
		return false;
	}
	if (!(document.custForm.custMobile.value.match(custMobile))) {
		document.getElementById("custMobileErr").innerHTML = '* Invalid Mobile Entered';
		return false;
	}
	
	if (!(document.custForm.custRegNum.value.match(custRegNum))) {
		document.getElementById("custRegNumErr").innerHTML = '* Invalid Registration Entered';
		return false;
	}
	if (!(document.custForm.custAddress.value.match(custAddress))) {
		document.getElementById("custAddressErr").innerHTML = '* Invalid Address Entered';
		return false;
	}
	
	return true;
}