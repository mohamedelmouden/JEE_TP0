<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${user != null ? 'Modifier' : 'Créer'} un utilisateur</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; }
        form { max-width: 450px; }
        label { display: block; margin-top: 12px; font-weight: bold; }
        input, select { width: 100%; padding: 7px; margin-top: 4px; box-sizing: border-box; }
        button { margin-top: 18px; padding: 9px 20px; background: #4CAF50; color: white; border: none; cursor: pointer; border-radius: 3px; }
        a { display: inline-block; margin-top: 12px; }
    </style>
</head>
<body>
<h1>${user != null ? 'Modifier' : 'Créer'} un utilisateur</h1>

<form action="${user != null ? 'update-user' : 'create-user'}" method="post">
    <c:if test="${user != null}">
        <input type="hidden" name="id" value="${user.id}"/>
    </c:if>

    <label>Prénom</label>
    <input type="text" name="firstName" value="${user.firstName}" required/>

    <label>Nom</label>
    <input type="text" name="lastName" value="${user.lastName}" required/>

    <label>Email</label>
    <input type="email" name="email" value="${user.email}" required/>

    <label>${user != null ? 'Nouveau mot de passe (laisser vide pour ne pas changer)' : 'Mot de passe'}</label>
    <input type="password" name="password" ${user == null ? 'required' : ''}/>

    <label>Rôle</label>
    <select name="role">
        <option value="USER" ${user.role == 'USER' ? 'selected' : ''}>USER</option>
        <option value="ADMIN" ${user.role == 'ADMIN' ? 'selected' : ''}>ADMIN</option>
    </select>

    <c:if test="${user != null}">
        <label>Actif</label>
        <select name="active">
            <option value="true" ${user.active ? 'selected' : ''}>Oui</option>
            <option value="false" ${!user.active ? 'selected' : ''}>Non</option>
        </select>
    </c:if>

    <button type="submit">${user != null ? 'Mettre à jour' : 'Créer'}</button>
</form>

<a href="users">← Retour à la liste</a>
</body>
</html>
