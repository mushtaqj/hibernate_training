package se.cambio.training.factories;

import java.util.List;

import se.cambio.training.entities.AbstractEntity;

/**
 * @author MJameel
 * @since on 7/24/2017.
 */
public interface InventoryControl<T extends AbstractEntity>
{
	List<T> populate();
}
