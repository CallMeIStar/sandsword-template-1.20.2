summon armor_stand ~ ~ ~ {Invisible: true, Invulnerable: true, Tags: ["swind"]}
tp @e[tag=swind,limit=1,sort=nearest,type=armor_stand] @p[nbt={cardinal_components:{"origins:origin":{OriginLayers:[{Origin:"aridian:aridian"}]}}}]
power grant @e[type=minecraft:armor_stand,limit=1,sort=nearest,tag=swind] aridian:sandwind