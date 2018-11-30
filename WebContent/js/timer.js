function startTimer(duration, display) {
	var timer = duration, hours, minutes, seconds;
	setInterval(function() {
		
		hours = parseInt(timer / (60 * 60), 10)
		minutes = parseInt(timer % (60 * 60) / 60, 10)
		seconds = parseInt(timer % 60, 10);
		hours = hours < 10 ? "0" + hours : hours;
		minutes = minutes < 10 ? "0" + minutes : minutes;
		seconds = seconds < 10 ? "0" + seconds : seconds;

		display.textContent = hours + ":" + minutes + ":" + seconds;

		if (--timer < 0) {
			clearInterval(x);
			document.getElementById("clock").innerHTML = "Hết thời gian";
		}
	}, 1000);
}

$(document).ready(function() {
	var time = document.getElementById("clock").innerHTML,
	h = time.split(':')[0],
	m = time.split(':')[1],
	duration = h*60*60 + m*60,
	display = document.querySelector('#clock');
	startTimer(duration, display);
});