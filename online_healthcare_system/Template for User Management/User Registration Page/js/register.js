document.getElementById('registrationForm').addEventListener('submit', function (e) {
    e.preventDefault();
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    if (password.length < 6) {
        alert('Password must be at least 6 characters long');
        return;
    }

    alert('Registration successful for ' + username);
});
