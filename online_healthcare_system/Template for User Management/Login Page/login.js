document.getElementById('loginForm').addEventListener('submit', function (e) {
    e.preventDefault();
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    if (password.trim() === '') {
        alert('Password cannot be empty');
        return;
    }

    alert('Welcome back, ' + username);
});
