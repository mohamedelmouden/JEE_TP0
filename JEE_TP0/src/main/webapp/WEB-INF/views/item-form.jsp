<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${item != null ? 'Modifier' : 'Créer'} un article</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; }
        form { max-width: 500px; }
        label { display: block; margin-top: 12px; font-weight: bold; }
        input, textarea, select { width: 100%; padding: 7px; margin-top: 4px; box-sizing: border-box; }
        textarea { height: 80px; resize: vertical; }
        button { margin-top: 18px; padding: 9px 20px; background: #2196F3; color: white; border: none; cursor: pointer; border-radius: 3px; }
        a { display: inline-block; margin-top: 12px; }
    </style>
</head>
<body>
<h1>${item != null ? 'Modifier' : 'Créer'} un article</h1>

<form action="${item != null ? 'update-item' : 'create-item'}" method="post">
    <c:if test="${item != null}">
        <input type="hidden" name="id" value="${item.id}"/>
    </c:if>

    <label>Titre</label>
    <input type="text" name="title" value="${item.title}" required/>

    <label>Détails</label>
    <textarea name="details">${item.details}</textarea>

    <label>Prix unitaire (€)</label>
    <input type="number" name="unitPrice" value="${item.unitPrice}" step="0.01" min="0" required/>

    <label>Quantité en stock</label>
    <input type="number" name="quantityInStock" value="${item.quantityInStock}" min="0" required/>

    <label>Code SKU</label>
    <input type="text" name="skuCode" value="${item.skuCode}"/>

    <label>Catégorie</label>
    <input type="text" name="category" value="${item.category}"/>

    <label>Seuil de réapprovisionnement</label>
    <input type="number" name="reorderThreshold" value="${item.reorderThreshold}" min="0"/>

    <button type="submit">${item != null ? 'Mettre à jour' : 'Créer'}</button>
</form>

<a href="items">← Retour à la liste</a>
</body>
</html>
