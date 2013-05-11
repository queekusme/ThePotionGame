THE POTION GAME:
================

<dl>
  <dt>Minimum System Requirements:</dt>
  <dd>Java 1.6.0_31 or better</dd>
  <dd>To check your version run this file i made: https://gist.github.com/queekusme/5512729</dd>
</dl>

<dl>
  <dt>Current 'ingredients' avaliable:</dt>
  <dd>wings</dd>
  <dd>flowers</dd>
  <dd>plague</dd>
  <dd>heat100</dd>
</dl>

<dl>
  <dt>Implemented effects:</dt>
  <dd>Health</dd>
  <dd>Luck</dd>
  <dd>Fortune</dd>
  <dd>Love</dd>
  <dd>Heat(partly implemented)</dd>
</dl>

<dl>
  <dt>Implemented, un-usable effects:</dt>
  <dd>Wait</dd>
</dl>

<dl>
  <dt>Implemented recipes:</dt>
  <dd>{wings, wings} = Potion of 20 Health</dd>
  <dd>{plague, heat100, wings} = Potion of 100 Cure(Plague)</dd>
</dl>

How To Use
----------

    after loading the game up you will see a window which is a large box and a smaller box,
    The smaller box is the input and the larger box is the output.

Set Recipes:

    type 'add wings' to add wings to the current potion
    type 'add wings' to add wings to the current potion again
    type bottle to create the potion, this should produce a potion of 20 health, this is an example of a set recipe.

Custon effects depending on ingredient combinations:

    type 'add wings' to add wings to the current potion
    type 'add flowers' to add flowers to the current potion
    type bottle to create the potion, this should produce a potion of 10 Fortune This is an example of 2 ingredients together producing a different effect just because they have been combined

Combining Effects:

    type 'add flowers' to add flowers to the current potion
    type 'add flowers' to add flowers to the current potion again
    type bottle to create the potion, this should produce a potion of 10 Luck, 10 Luck
    (This is combined into 20 Luck), This is an example of multiple effects on one potion

Multiple Effects:

    Many different effects can be combined for example try this potion:
    add wings
    add wings
    add flowers
    bottle
	
	or
	
	add wings
    add wings
    add flowers
    add flowers
    add flowers
    add flowers
	bottle
	
