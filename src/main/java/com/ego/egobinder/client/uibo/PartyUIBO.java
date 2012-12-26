package com.ego.egobinder.client.uibo;

import com.ego.egobinder.layout.annotation.EgoEntity;
import com.ego.egobinder.layout.annotation.EgoField;
import com.ego.egobinder.shared.model.Party;

/**
 * @author Oliver
 * @since 26.12.12 00:58
 */
@EgoEntity(name="Party")
public class PartyUIBO implements Party
{
    private String firstName;
    private String lastName;

    @Override
    public String getFirstName()
    {
        return firstName;
    }

    @Override
    @EgoField(name="firstName")
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    @Override
    @EgoField(name="lastName")
    public String getLastName()
    {
        return lastName;
    }

    @Override
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
}
